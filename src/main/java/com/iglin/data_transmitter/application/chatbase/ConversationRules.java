package com.iglin.data_transmitter.application.chatbase;

import com.iglin.data_transmitter.domain.chatbase.common.exception.NoConversationsException;
import com.iglin.data_transmitter.domain.chatbase.model.Conversation;

import java.time.Duration;
import java.util.List;

public class ConversationRules {

    public static void throwIfEmpty(List<Conversation> conversations, String exceptionMessage) {
        if (conversations.isEmpty()) {
            throw new NoConversationsException(exceptionMessage);
        }
    }

    public static List<Conversation> filterTransitions(Duration delay,List<Conversation> conversations) {
        return conversations.stream()
                .filter(c -> c.isReadyForTransition(delay))
                .toList();
    }

}
