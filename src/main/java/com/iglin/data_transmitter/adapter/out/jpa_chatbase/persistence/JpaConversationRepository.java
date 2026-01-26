package com.iglin.data_transmitter.adapter.out.jpa_chatbase.persistence;

import com.iglin.data_transmitter.domain.chatbase.common.type.ConversationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaConversationRepository extends JpaRepository<JpaConversationEntity, String> {

    Optional<JpaConversationEntity> findByPayload_CustomerEmail(String payloadCustomerEmail);

    List<JpaConversationEntity> findAllByConversationStatus(ConversationStatus conversationStatus);
    
}
