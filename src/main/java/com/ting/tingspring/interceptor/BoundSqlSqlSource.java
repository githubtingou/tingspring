package com.ting.tingspring.interceptor;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 内部辅助类，作用是包装sql
 *
 * @author LISHUANG
 * @date 2019/11/28
 */
public class BoundSqlSqlSource implements SqlSource {
    private BoundSql boundSql;

    public BoundSqlSqlSource(BoundSql boundSql) {
        this.boundSql = boundSql;
    }


    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return boundSql;
    }
}