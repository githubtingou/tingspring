package com.ting.tingspring.handle;

import com.ting.tingspring.commom.ResponseCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常类
 *
 * @author LISHUANG
 * @date 2019/10/24
 */
@Getter
@Setter
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String showMsg;

    private ResponseCode responseCode;


    public MyException(String message, ResponseCode responseCode) {
        super(responseCode.toString());
        this.showMsg = message;
        this.responseCode = responseCode;
    }

    public MyException(ResponseCode responseCode) {
        this.showMsg = "";
        this.responseCode = responseCode;
    }
}

