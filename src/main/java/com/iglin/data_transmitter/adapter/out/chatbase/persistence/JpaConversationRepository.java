package com.iglin.data_transmitter.adapter.out.chatbase.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaConversationRepository extends JpaRepository<JpaConversationEntity, String> {
}
