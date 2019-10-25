package com.ting.tingspring.handle;

import com.ting.tingspring.commom.ResponseCode;
import com.ting.tingspring.commom.ResponseDto;
import com.ting.tingspring.utils.ResponseDtoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 统一异常处理
 *
 * @author LISHUANG
 * @date 2019/10/24
 */
@ControllerAdvice
@Component
@Slf4j
public class ExceptionHandle {


    /**
     * 全局异常处理
     *
     * @param request httpServletRequest
     * @param e       异常
     * @return 封装后的异常的返参
     */
    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public ResponseDto exceptionHandel(HttpServletRequest request, Exception e) {

        /**
         * 自定义异常处理
         */
        if (e instanceof MyException) {
            MyException myException = (MyException) e;
            return ResponseDtoUtils.buildResponseDtoError(myException.getResponseCode(), myException.getShowMsg());
        }

        /**
         * valid 异常处理
         */
        if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            StringBuffer sb = new StringBuffer();

            for (FieldError fieldError : fieldErrors) {
                /* 获取valid定义的message*/
                /**
                 * 字段value
                 */
                Object rejectedValue = fieldError.getRejectedValue();
                /**
                 * 字段key
                 */
                String field = fieldError.getField();
                /**
                 * message
                 */
                String defaultMessage = fieldError.getDefaultMessage();
                sb.append(defaultMessage).append(";");
            }
            return ResponseDtoUtils.buildResponseCodeValid(sb.toString());

        }

        return ResponseDtoUtils.buildResponseDtoError(ResponseCode.REQ_FAIL, e.getMessage());

    }

}