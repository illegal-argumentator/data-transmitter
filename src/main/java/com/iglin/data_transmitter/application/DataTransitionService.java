package com.iglin.data_transmitter.application;

import com.iglin.data_transmitter.domain.chatbase.common.type.ConversationStatus;
import com.iglin.data_transmitter.domain.chatbase.model.Conversation;
import com.iglin.data_transmitter.domain.smartmoving.model.Lead;
import com.iglin.data_transmitter.port.out.chatbase.ConversationCommandPort;
import com.iglin.data_transmitter.port.out.smartmoving.LeadCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataTransitionService {

    private final LeadCommandPort leadCommandPort;

    private final ConversationCommandPort conversationCommandPort;

    public void processDataTransition(List<Conversation> conversations) {
        for (Conversation conversation : conversations) {
            Lead lead = Lead.builder()
                    .fullName(conversation.getPayload().getCustomerName())
                    .email(conversation.getPayload().getCustomerEmail())
                    .phoneNumber(conversation.getPayload().getCustomerPhone())
                    .build();

            leadCommandPort.save(lead);
            conversationCommandPort.updateStatus(conversation.getPayload().getCustomerEmail(), ConversationStatus.CREATED);
        }
    }
}
