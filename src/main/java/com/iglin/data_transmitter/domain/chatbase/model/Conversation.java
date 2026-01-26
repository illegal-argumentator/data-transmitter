package com.iglin.data_transmitter.domain.chatbase.model;

import com.iglin.data_transmitter.domain.chatbase.common.type.ConversationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Conversation {

        private String eventType;
        private String chatbotId;
        private Payload payload;
        private ConversationStatus conversationStatus;
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
