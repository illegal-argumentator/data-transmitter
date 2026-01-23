package com.iglin.data_transmitter.adapter.in.chatbase;

import com.iglin.data_transmitter.domain.chatbase.model.Conversation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
@RequiredArgsConstructor
public class ChatbaseParser {

    @Value("${chatbase.api-key}")
    private String CHATBASE_API_KEY;

    private static final String HEX_FORMATER = "%02x";
    private static final String PARSER_ALGORITHM = "HmacSHA1";

    private final ObjectMapper objectMapper;

    public Conversation parseConversation(String rawBody) {
        return objectMapper.readValue(rawBody, Conversation.class);
    }

    public String parseSignature(String rawBody) {
        try {
            Mac mac = Mac.getInstance(PARSER_ALGORITHM);
            SecretKeySpec keySpec =
                    new SecretKeySpec(CHATBASE_API_KEY.getBytes(StandardCharsets.UTF_8), PARSER_ALGORITHM);
            mac.init(keySpec);

            byte[] rawHmac = mac.doFinal(rawBody.getBytes(StandardCharsets.UTF_8));

            return bytesToHex(rawHmac);
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(String.format(HEX_FORMATER, b));
        }
        return hex.toString();
    }

}
