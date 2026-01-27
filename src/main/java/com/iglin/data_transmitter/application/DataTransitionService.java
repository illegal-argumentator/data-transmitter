package com.iglin.data_transmitter.application;

import com.iglin.data_transmitter.application.chatbase.ConversationRules;
import com.iglin.data_transmitter.domain.chatbase.common.type.ConversationStatus;
import com.iglin.data_transmitter.domain.chatbase.model.Conversation;
import com.iglin.data_transmitter.domain.smartmoving.model.Lead;
import com.iglin.data_transmitter.port.out.chatbase.ConversationCommandPort;
import com.iglin.data_transmitter.port.out.chatbase.ExternalConversationQueryPort;
import com.iglin.data_transmitter.port.out.smartmoving.LeadCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataTransitionService {

    private final LeadCommandPort leadCommandPort;

    private final ConversationCommandPort conversationCommandPort;

    private final ExternalConversationQueryPort externalConversationQueryPort;

    public List<Conversation> retrieveExternalConversations(List<String> chatbotIds) {
        List<Conversation> externalConversations = new ArrayList<>();

        for (String chatbotId : chatbotIds) {
            Conversation conversation = externalConversationQueryPort.get(chatbotId);
            externalConversations.add(conversation);
        }

        ConversationRules.throwIfEmpty(externalConversations, "No external conversations were found.");

        return externalConversations;
    }

    public void transitData(List<Conversation> conversations) {
        for (Conversation conversation : conversations) {
            leadCommandPort.save(mapConversationToLead(conversation));
            conversationCommandPort.updateStatus(conversation.getId(), ConversationStatus.CREATED);
        }
    }

    public Lead mapConversationToLead(Conversation conversation) {
        return Lead.builder()
                .email(conversation.getPayload().getCustomerEmail())
                .fullName(conversation.getPayload().getCustomerName())
                .phoneNumber(conversation.getPayload().getCustomerPhone())
                .build();
    }
}
