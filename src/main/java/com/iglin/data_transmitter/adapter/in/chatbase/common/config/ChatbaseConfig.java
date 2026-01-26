package com.iglin.data_transmitter.adapter.in.chatbase.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class ChatbaseConfig {

    @Bean
    public Duration conversationDelay(
            @Value("${chatbase.conversation.transition}") long seconds
    ) {
        return Duration.ofSeconds(seconds);
    }

}
