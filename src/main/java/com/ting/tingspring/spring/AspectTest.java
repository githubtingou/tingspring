package com.ting.tingspring.spring;

import com.alibaba.fastjson.JSON;
import com.ting.tingspring.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.ting.tingspring.spring.AopThreadLocal.requestNo;
import static com.ting.tingspring.spring.AopThreadLocal.startTime;

/**
 * 切面
 *
 * @author LISHUANG
 * @date 2019/10/22
 */
@Aspect
@Slf4j
@Component
public class AspectTest {

    @Pointcut("execution(public * com.ting.tingspring.controller..*.*(..)) ")
    public void tingAop() {

    }

    @Before("tingAop()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        String seqNo = UUID.randomUUID().toString();
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object[] args = joinPoint.getArgs();
        List<Object> list = new ArrayList<>();
        for (Object arg : args) {
            if (ObjectUtils.isEmpty(arg) || arg instanceof HttpServletRequest || arg instanceof HttpServletResponse
                    || arg instanceof HttpSession || arg instanceof MultipartFile) {
                continue;
            }
            if (arg instanceof UserDto) {
                log.info("修改前：{}", JSON.toJSON(arg));
                UserDto userDto = (UserDto) arg;
                userDto.setName("修改名称成功，success");
                userDto.setAge(666);
            }
            list.add(arg);

        }

        requestNo.set(seqNo);
        log.info("requestNo : {}, url: {} ,requestParams : {}", seqNo, request.getRequestURL(), JSON.toJSON(list));
    }

    /**
     * 打印返回参数日志
     *
     * @param responseVo
     */
    @AfterReturning(pointcut = "tingAop()", returning = "responseVo")
    public void doAfterReturning(Object responseVo) {
        log.info("requestNo : " + requestNo.get() + " responseVo : " + JSON.toJSON(responseVo));
        log.info("requestNo : " + requestNo.get() + " cost(ms) : " + (System.currentTimeMillis() - startTime.get()));
        AopThreadLocal.clearAll();
    }

}
