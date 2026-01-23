package com.iglin.data_transmitter.adapter.out.chatbase.mapper;

import com.iglin.data_transmitter.adapter.out.chatbase.persistence.JpaConversationEntity;
import com.iglin.data_transmitter.adapter.out.common.MapStructConfig;
import com.iglin.data_transmitter.domain.chatbase.model.Conversation;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface ConversationMapper {

    JpaConversationEntity toJpaConversation(Conversation conversation);

}
