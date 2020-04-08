package com.pg.bbs.handler;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1770144313787602732L;

    private Integer code;

    private String msg;

    public BusinessException(BusinessStatus businessStatus) {
        this.code = businessStatus.getCode();
        this.msg = businessStatus.getMsg();
    }

    public BusinessException(Integer code2, String string) {
        this.code = code2;
        this.msg = string;
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
}
