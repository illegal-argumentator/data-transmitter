package com.iglin.data_transmitter.adapter.out.common.http;

import com.iglin.data_transmitter.adapter.out.common.exception.InternalServerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class OkHttpService {

    private final ObjectMapper objectMapper;

    private final OkHttpClient okHttpClient;

    public <T> T handleApiRequest(Request request, Class<T> responseTarget) {
        return objectMapper.readValue(handleApiRequest(request), responseTarget);
    }

    public String handleApiRequest(Request request) {
        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                String message = objectMapper.readValue(response.body().string(), Object.class).toString();
                throw new InternalServerException(message);
            }

            return response.body().string();
        } catch (IOException e) {
            throw new InternalServerException(e.getMessage());
        }
    }
}
