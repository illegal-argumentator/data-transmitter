package com.iglin.data_transmitter.adapter.in.chatbase;

import com.iglin.data_transmitter.adapter.in.HttpRequestParser;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChatbaseWebhookHandler {

    private final HttpRequestParser httpRequestParser;

    private final ChatbaseParser chatbaseParser;

    private final ChatbaseSignatureValidator chatbaseSignatureValidator;

    public void handleFormSubmission(HttpServletRequest request, String headerSignature) {
        String rawBody = httpRequestParser.parse(request);
        String parsedSignature = chatbaseParser.parseSignature(rawBody);
        log.info("Rawbody: {}, signature: {}", rawBody, parsedSignature);
//        chatbaseSignatureValidator.validate(parsedSignature, headerSignature);
//        chatbaseService.save(chatbaseParser.parseConversation(rawBody));
    }

}
