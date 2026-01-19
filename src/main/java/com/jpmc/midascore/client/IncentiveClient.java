package com.jpmc.midascore.client;

import com.jpmc.midascore.config.RestTemplateConfig;
import com.jpmc.midascore.foundation.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class IncentiveClient {

    private final RestTemplate restTemplate;

    public IncentiveClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public float fetchIncentive(Transaction transaction) {
        Incentive incentive = restTemplate.postForObject("http://localhost:8080/incentive", transaction, Incentive.class);

        return incentive != null ? incentive.getAmount() : 0f;
    }
}
