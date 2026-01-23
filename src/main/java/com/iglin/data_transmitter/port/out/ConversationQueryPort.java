package com.iglin.data_transmitter.port.out;

import com.iglin.data_transmitter.domain.chatbase.common.type.ConversationStatus;
import com.iglin.data_transmitter.domain.chatbase.model.Conversation;

import java.util.List;

public interface ConversationQueryPort {

    List<Conversation> findAllByStatus(ConversationStatus conversationStatus);

}
