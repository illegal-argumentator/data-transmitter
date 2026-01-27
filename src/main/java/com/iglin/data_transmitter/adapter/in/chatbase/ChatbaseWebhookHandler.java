package com.iglin.data_transmitter.adapter.in.chatbase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChatbaseWebhookHandler {

    private final ChatbaseParser chatbaseParser;

    private final ChatbaseSignatureValidator chatbaseSignatureValidator;

    public void handleFormSubmission(String body, String headerSignature) {
        String parsedSignature = chatbaseParser.parseSignature(body);
        log.info("Rawbody: {}, signature: {}", body, parsedSignature);
//        chatbaseSignatureValidator.validate(parsedSignature, headerSignature);
//        chatbaseService.save(chatbaseParser.parseConversation(rawBody));
    }

}
