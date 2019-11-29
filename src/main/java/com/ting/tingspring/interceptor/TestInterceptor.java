package com.ting.tingspring.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;

import java.util.Properties;

/**
 * 测试
 *
 * @author LISHUANG
 * @date 2019/11/28
 */
@Intercepts(@Signature(
        type = Executor.class, method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
)
@Slf4j
public class TestInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        this.queryInvocation(invocation);
        // 责任传递
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {

        return Plugin.wrap(target, this);

    }

    @Override
    public void setProperties(Properties properties) {

    }


    /**
     * 查询语句拦截
     *
     * @param invocation
     */
    private void queryInvocation(Invocation invocation) {
        log.info("进入自定义query拦截器");

        MappedStatement arg = (MappedStatement) invocation.getArgs()[0];

        // 获取sql
        SqlSource sqlSource = arg.getSqlSource();
        Object param = invocation.getArgs()[1];
        BoundSql boundSql = sqlSource.getBoundSql(param);
        String sql = boundSql.getSql();
        if (StringUtils.isEmpty(sql)) {
            return;
        }

        // 创建一个新的MappedStatement
        MappedStatement newMappedStatement = this.copyFromMappedStatement(arg, new BoundSqlSqlSource(boundSql));

        MetaObject metaObject = MetaObject.forObject(newMappedStatement,
                new DefaultObjectFactory(), new DefaultObjectWrapperFactory(),
                new DefaultReflectorFactory());
        metaObject.setValue("sqlSource.boundSql.sql", this.newSql(sql));
        invocation.getArgs()[0] = newMappedStatement;
    }

    /**
     * 创建新的MappedStatement
     *
     * @param ms
     * @param newSqlSource
     * @return
     */
    private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(),
                newSqlSource, ms.getSqlCommandType());

        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length > 0) {
            builder.keyProperty(ms.getKeyProperties()[0]);
        }
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        builder.resultMaps(ms.getResultMaps());
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());
        return builder.build();
    }


    /**
     * 自定义sql
     *
     * @param sql
     * @return java.lang.String
     */
    public String newSql(String sql) {
        log.info("封装前的sql: {}", sql);
        sql += " limit 1";
        log.info("封装后的sql: {}", sql);
        return sql;
    }
}
