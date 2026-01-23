package com.iglin.data_transmitter.adapter.in;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.stream.Collectors;

@Slf4j
@Component
public class HttpRequestParser {

    public String parse(HttpServletRequest request) {
        try {
            return request.getReader()
                    .lines()
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            log.warn("Exception parsing request: ", e);
            throw new RuntimeException(e);
        }
    }
}
