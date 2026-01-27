package com.iglin.data_transmitter.adapter.out.api_chatbase;

import com.iglin.data_transmitter.adapter.out.common.http.OkHttpService;
import com.iglin.data_transmitter.domain.chatbase.model.Conversation;
import com.iglin.data_transmitter.port.out.chatbase.ExternalConversationQueryPort;
import lombok.RequiredArgsConstructor;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.iglin.data_transmitter.adapter.out.common.constants.AuthorizationConstants.*;

@Component
@RequiredArgsConstructor
public class ExternalConversationQueryAdapter implements ExternalConversationQueryPort {

    @Value("${chatbase.api-key}")
    private String CHATBASE_API_KEY;

    private final OkHttpService okHttpService;

    @Override
    public Conversation get(String chatbotId) {
        Request request = new Request.Builder()
                .url(ChatbaseApiPathBuilder.buildGetConversations(chatbotId))
                .header(AUTHORIZATION_HEADER, BEARER_PREFIX + CHATBASE_API_KEY)
                .get()
                .build();
        return okHttpService.handleApiRequest(request, Conversation.class);
    }

}
