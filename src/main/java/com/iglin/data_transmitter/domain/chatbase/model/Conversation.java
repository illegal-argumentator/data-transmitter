package com.iglin.data_transmitter.domain.chatbase.model;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public abstract class Conversation {

        private String eventType;
        private String chatbotId;
        private Payload payload;
        private LocalDateTime createdDate;

    @Data
    public static final class Payload {

            private String conversationId;
            private String customerEmail;
            private String customerName;
            private String customerPhone;

    }

    public boolean isReadyForTransition(Duration transition) {
        return createdDate.isBefore(LocalDateTime.now().minus(transition))
                || createdDate.isEqual(LocalDateTime.now().minus(transition));
    }

}
