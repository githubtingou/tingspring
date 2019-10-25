package com.ting.tingspring.commom;

/**
 * 返参枚举值
 *
 * @author LISHUANG
 * @date 2019/10/24
 */

public enum ResponseCode {
    REQ_SUCCESS(10000, "请求成功", true),

    REQ_FAIL(20000, "请求失败", false);

    private Integer code;
    private String msg;
    private boolean success;

    ResponseCode(Integer code, String msg, boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
