package com.iglin.data_transmitter.adapter.out.chatbase;

import com.iglin.data_transmitter.adapter.out.chatbase.mapper.ConversationMapper;
import com.iglin.data_transmitter.adapter.out.chatbase.persistence.JpaConversationEntity;
import com.iglin.data_transmitter.adapter.out.chatbase.persistence.JpaConversationRepository;
import com.iglin.data_transmitter.domain.chatbase.common.type.ConversationStatus;
import com.iglin.data_transmitter.domain.chatbase.model.Conversation;
import com.iglin.data_transmitter.port.out.chatbase.ConversationCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConversationCommandAdapter implements ConversationCommandPort {

    private final ConversationMapper conversationMapper;

    private final JpaConversationRepository jpaConversationRepository;

    @Override
    public void save(Conversation conversation) {
        JpaConversationEntity jpaConversation = conversationMapper.toJpaConversation(conversation);
        jpaConversation.setConversationStatus(ConversationStatus.PENDING);
        jpaConversationRepository.save(jpaConversation);
    }

    @Override
    public void update(String id, Conversation conversation) {

    }
}
