package com.app.advise;

import com.app.exceptions.ServiceException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommenAdvise {
    @ExceptionHandler({ ServiceException.class })
    protected ApiErrorResponse handleApiException(ServiceException ex) {
        return new ApiErrorResponse(ex.getErrorCode(), ex.getMessage());
    }

}
