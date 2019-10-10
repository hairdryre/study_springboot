package com.zhoutianyu.learnspringboot.exception;

public abstract class AbstractBusinessException extends RuntimeException {

    private int code;

    public AbstractBusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public AbstractBusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
