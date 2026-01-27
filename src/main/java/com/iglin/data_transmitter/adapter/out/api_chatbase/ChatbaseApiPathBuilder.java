package com.iglin.data_transmitter.adapter.out.api_chatbase;

public final class ChatbaseApiPathBuilder {

    private static final String BASE_URL = "https://www.chatbase.co/api/v1";

    public static String buildGetConversations(String chatbotId) {
        return BASE_URL + "/get-conversations?chatbotId=" + chatbotId;
    }

}
