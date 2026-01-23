package com.iglin.data_transmitter.adapter.in.chatbase;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/webhook")
public class ChatbaseWebhookController {

    private final ChatbaseWebhookHandler chatbaseWebhookHandler;

    @PostMapping("/form-submission")
    public void handleFormSubmission(
            HttpServletRequest request,
            @RequestHeader("x-chatbase-signature") String signature
    ) {
        chatbaseWebhookHandler.handleFormSubmission(request, signature);
    }
}
