package com.iglin.data_transmitter.application;

import com.iglin.data_transmitter.application.chatbase.ChatbaseService;
import com.iglin.data_transmitter.domain.chatbase.common.type.ConversationStatus;
import com.iglin.data_transmitter.domain.chatbase.model.Conversation;
import com.iglin.data_transmitter.port.out.chatbase.ConversationQueryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataTransitionOrchestrator {

    private final ConversationQueryPort conversationQueryPort;

    private final ChatbaseService chatbaseService;
    
    public void processDataTransition() {
        List<Conversation> pendingConversations = conversationQueryPort.findAllByStatus(ConversationStatus.PENDING);
        log.info("Retrieved {} pending conversations.", pendingConversations.size());

        List<Conversation> transitionConversations = chatbaseService.filterReadyForTransitConversations(pendingConversations);
        log.info("Filtered {} transition conversations.", transitionConversations.size());

    }

}
