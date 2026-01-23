package com.iglin.data_transmitter.application.chatbase;

import com.iglin.data_transmitter.domain.chatbase.model.Conversation;
import com.iglin.data_transmitter.port.out.chatbase.ConversationCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatbaseService {

    private final ConversationCommandPort conversationCommandPort;

    public void save(Conversation conversation) {
        conversationCommandPort.save(conversation);
    }

    public void update(String id, Conversation conversation) {
        conversationCommandPort.update(id, conversation);
    }

}
