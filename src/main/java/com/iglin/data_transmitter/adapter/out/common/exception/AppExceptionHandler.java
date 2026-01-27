package com.iglin.data_transmitter.adapter.out.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public void handleEntityNotFoundException(EntityNotFoundException e) {
        log.error(e.getMessage());
    }

    @ExceptionHandler(InternalServerException.class)
    public void handleInternalServerException(InternalServerException e) {
        log.error(e.getMessage());
    }

}
