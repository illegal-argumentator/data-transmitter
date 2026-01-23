package com.iglin.data_transmitter.domain.chatbase.model;

import lombok.Data;

@Data
public abstract class Conversation {

        private String eventType;
        private String chatbotId;
        private Payload payload;

    @Data
    public static final class Payload {

            private String conversationId;
            private String customerEmail;
            private String customerName;
            private String customerPhone;

    }
}
