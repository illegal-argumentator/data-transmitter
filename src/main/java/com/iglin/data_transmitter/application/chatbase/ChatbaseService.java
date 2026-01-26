package com.iglin.data_transmitter.application.chatbase;

import com.iglin.data_transmitter.domain.chatbase.model.Conversation;
import com.iglin.data_transmitter.port.out.ConversationCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatbaseService {

    @Value("${chatbase.conversation.transition}")
    private long CONVERSATION_TRANSITION;

    private final ConversationCommandPort conversationCommandPort;

    public void save(Conversation conversation) {
        conversationCommandPort.save(conversation);
    }

    public void update(String id, Conversation conversation) {
        conversationCommandPort.update(id, conversation);
    }

    public List<Conversation> filterReadyForTransitionConversations(List<Conversation> conversations) {
        Duration transition = Duration.ofSeconds(CONVERSATION_TRANSITION);

        return conversations.stream()
                .filter(c -> c.isReadyForTransition(transition))
                .toList();
    }
}
