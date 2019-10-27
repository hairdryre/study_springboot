package com.zhoutianyu.learnspringboot.exception;

public class FormRepeatException extends AbstractBusinessException {

    private static final int FORM_REPEAT_CODE = -2;

    public FormRepeatException(String message) {
        super(FORM_REPEAT_CODE, message);
    }
}
