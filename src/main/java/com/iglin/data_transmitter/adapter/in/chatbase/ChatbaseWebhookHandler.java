package com.iglin.data_transmitter.adapter.in.chatbase;

import com.iglin.data_transmitter.adapter.in.common.HttpRequestParser;
import com.iglin.data_transmitter.application.chatbase.ChatbaseService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatbaseWebhookHandler {

    private final ChatbaseService chatbaseService;

    private final HttpRequestParser httpRequestParser;

    private final ChatbaseParser chatbaseParser;

    private final ChatbaseSignatureValidator chatbaseSignatureValidator;

    public void handleFormSubmission(HttpServletRequest request, String headerSignature) {
        String rawBody = httpRequestParser.parse(request);
        String parsedSignature = chatbaseParser.parseSignature(rawBody);
        chatbaseSignatureValidator.validate(parsedSignature, headerSignature);
        chatbaseService.save(chatbaseParser.parseConversation(rawBody));
    }

}
