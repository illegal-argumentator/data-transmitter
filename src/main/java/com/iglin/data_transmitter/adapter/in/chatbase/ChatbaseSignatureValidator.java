package com.iglin.data_transmitter.adapter.in.chatbase;

import org.springframework.stereotype.Component;

@Component
public class ChatbaseSignatureValidator {

    public void validate(String parsedSignature, String requestSignature) {
        if (!parsedSignature.equals(requestSignature)) {
            throw new IllegalArgumentException("Signature didn't match.");
        }
    }

}
