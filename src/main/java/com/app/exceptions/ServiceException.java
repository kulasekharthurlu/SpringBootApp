package com.app.exceptions;

import org.springframework.stereotype.Component;

@Component
public class ServiceException extends RuntimeException {
    private Integer errorCode;
    private String errorMessage;

    public ServiceException(Integer errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ServiceException() {
        super();
    }
}
