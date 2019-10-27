package com.zhoutianyu.learnspringboot.exception;

public class FieldInvalidException extends AbstractBusinessException {

    private static final int FIELD_INVALID_CODE = -1;

    public FieldInvalidException(String message) {
        super(FIELD_INVALID_CODE, message);
    }

    public FieldInvalidException(String message, Throwable cause) {
        super(FIELD_INVALID_CODE, message, cause);
    }
}
