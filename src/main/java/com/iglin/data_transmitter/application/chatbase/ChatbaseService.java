package com.iglin.data_transmitter.application.chatbase;

import com.iglin.data_transmitter.domain.chatbase.model.Conversation;
import com.iglin.data_transmitter.port.out.chatbase.ConversationCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public List<Conversation> filterReadyForTransitConversations(List<Conversation> conversations) {
        LocalDateTime minus = LocalDateTime.now().minusSeconds(CONVERSATION_TRANSITION);

        return conversations.stream()
                .filter(conversation -> conversation.getCreatedDate().isEqual(minus)
                        || conversation.getCreatedDate().isBefore(minus))
                .toList();
    }
}
