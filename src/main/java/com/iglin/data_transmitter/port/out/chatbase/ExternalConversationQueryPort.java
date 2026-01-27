package com.iglin.data_transmitter.port.out.chatbase;

import com.iglin.data_transmitter.domain.chatbase.model.Conversation;

public interface ExternalConversationQueryPort {

    Conversation get(String chatbotId);

}
