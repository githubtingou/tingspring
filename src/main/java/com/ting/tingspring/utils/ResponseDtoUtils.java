package com.ting.tingspring.utils;

import com.ting.tingspring.commom.ResponseCode;
import com.ting.tingspring.commom.ResponseDto;

/**
 * 封转返参数据
 *
 * @author LISHUANG
 * @date 2019/10/24
 */
public class ResponseDtoUtils {
    /**
     * 封转错误信息
     *
     * @param responseCode
     * @param showMsg
     * @return
     */
    public static ResponseDto buildResponseDtoError(ResponseCode responseCode, String showMsg) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMsg(showMsg);
        responseDto.setCode(responseCode.getCode());
        return responseDto;
    }

    /**
     * 根据responseCode封转返参
     *
     * @param responseCode
     * @return
     */
    public static ResponseDto buildResponseCode(ResponseCode responseCode) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMsg(responseCode.getMsg());
        responseDto.setCode(responseCode.getCode());
        responseDto.setSuccess(responseCode.isSuccess());
        return responseDto;
    }

    /**
     * valid异常
     *
     * @param msg
     * @return
     */
    public static ResponseDto buildResponseCodeValid(String msg) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(40000);
        responseDto.setMsg(msg);
        return responseDto;

    }
}
