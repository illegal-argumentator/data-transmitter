package com.iglin.data_transmitter.adapter.out.jpa_chatbase.persistence;

import com.iglin.data_transmitter.domain.chatbase.common.type.ConversationStatus;
import com.iglin.data_transmitter.domain.chatbase.model.Conversation;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class JpaConversationEntity extends Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private ConversationStatus conversationStatus;

    @CreatedDate
    private LocalDateTime createdDate;
}
