package com.iglin.data_transmitter.adapter.out.jpa_chatbase.persistence;

import com.iglin.data_transmitter.adapter.out.jpa_chatbase.mapper.ConversationMapper;
import com.iglin.data_transmitter.domain.chatbase.common.type.ConversationStatus;
import com.iglin.data_transmitter.domain.chatbase.model.Conversation;
import com.iglin.data_transmitter.port.out.chatbase.ConversationQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConversationQueryAdapter implements ConversationQueryPort {

    private final JpaConversationRepository jpaConversationRepository;

    private final ConversationMapper conversationMapper;

    @Override
    public List<Conversation> findAllByStatus(ConversationStatus conversationStatus) {
        List<JpaConversationEntity> jpaConversationEntities = jpaConversationRepository.findAllByConversationStatus(conversationStatus);
        return conversationMapper.toConversations(jpaConversationEntities);
    }

}
