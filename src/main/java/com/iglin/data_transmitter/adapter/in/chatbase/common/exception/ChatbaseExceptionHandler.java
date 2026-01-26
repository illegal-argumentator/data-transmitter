package com.iglin.data_transmitter.adapter.in.chatbase.common.exception;

import com.iglin.data_transmitter.domain.chatbase.common.exception.NoConversationsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ChatbaseExceptionHandler {

    @ExceptionHandler(NoConversationsException.class)
    public void handleNoConversationsException(NoConversationsException e) {
        log.info(e.getMessage());
    }

}
