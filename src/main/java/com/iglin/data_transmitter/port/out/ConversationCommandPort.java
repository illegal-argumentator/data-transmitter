package com.iglin.data_transmitter.port.out;

import com.iglin.data_transmitter.domain.chatbase.model.Conversation;

public interface ConversationCommandPort {

    void save(Conversation conversation);

    void update(String id, Conversation conversation);

}
