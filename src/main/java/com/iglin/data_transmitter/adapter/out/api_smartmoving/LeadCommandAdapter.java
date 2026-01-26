package com.iglin.data_transmitter.adapter.out.api_smartmoving;

import com.iglin.data_transmitter.adapter.out.common.http.OkHttpService;
import com.iglin.data_transmitter.domain.smartmoving.model.Lead;
import com.iglin.data_transmitter.port.out.smartmoving.LeadCommandPort;
import lombok.RequiredArgsConstructor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
@RequiredArgsConstructor
public class LeadCommandAdapter implements LeadCommandPort {

    @Value("${smartmoving.provider-key}")
    private String SMARTMOVING_PROVIDER_KEY;

    private final ObjectMapper objectMapper;

    private final OkHttpService okHttpService;

    @Override
    public void save(Lead lead) {
        String jsonBody = objectMapper.writeValueAsString(lead);

        // TODO refactor
        Request request = new Request.Builder()
                .url("https://api.smartmoving.com/api/leads/from-provider/v2?providerKey=" + SMARTMOVING_PROVIDER_KEY)
                .post(RequestBody.create(jsonBody, MediaType.get(APPLICATION_JSON_VALUE)))
                .build();
        okHttpService.handleApiRequest(request);
    }
}
