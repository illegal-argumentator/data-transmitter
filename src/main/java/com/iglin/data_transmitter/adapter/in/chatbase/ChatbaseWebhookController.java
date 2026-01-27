package com.iglin.data_transmitter.adapter.in.chatbase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.iglin.data_transmitter.adapter.in.chatbase.common.constants.ChatbaseConstants.CHATBASE_SIGNATURE_HEADER;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/webhook")
public class ChatbaseWebhookController {

    private final ChatbaseWebhookHandler chatbaseWebhookHandler;

    @PostMapping("/form-submission")
    public void handleFormSubmission(
            @RequestBody String body,
            @RequestHeader(CHATBASE_SIGNATURE_HEADER) String signature
    ) {
        log.info("Received request from chatbase webhook.");
        chatbaseWebhookHandler.handleFormSubmission(body, signature);
    }
}
