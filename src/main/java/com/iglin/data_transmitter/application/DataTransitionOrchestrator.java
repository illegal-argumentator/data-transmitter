package com.iglin.data_transmitter.application;

import com.iglin.data_transmitter.application.chatbase.ConversationRules;
import com.iglin.data_transmitter.domain.chatbase.common.type.ConversationStatus;
import com.iglin.data_transmitter.domain.chatbase.model.Conversation;
import com.iglin.data_transmitter.port.out.chatbase.ConversationQueryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataTransitionOrchestrator {

    private final Duration conversationDelay;

    private final ConversationQueryPort conversationQueryPort;

    private final DataTransitionService dataTransitionService;

    public void processDataTransition() {
        List<Conversation> pendingConversations = conversationQueryPort.findAllByStatus(ConversationStatus.PENDING);
        ConversationRules.throwIfEmpty(pendingConversations, "No pending conversations were found.");
        log.info("Retrieved {} pending conversations.", pendingConversations.size());

        List<Conversation> transitionConversations = ConversationRules.filterTransitions(conversationDelay, pendingConversations);
        log.info("Filtered {} transition conversations.", transitionConversations.size());

        List<Conversation> externalConversations = dataTransitionService.retrieveExternalConversations(transitionConversations.stream()
                .map(Conversation::getChatbotId)
                .toList());
        log.info("Retrieved {} external conversations.", externalConversations.size());

        dataTransitionService.transitData(externalConversations);
        log.info("Transition finished successfully.");
    }

}
