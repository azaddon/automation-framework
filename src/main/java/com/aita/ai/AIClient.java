package com.aita.ai;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AIClient {

    private static final String DEFAULT_BASE_URL = "http://localhost:8000";
    private static final String ANALYSIS_PATH = "/api/v1/analysis/failures";

    private static final ObjectMapper mapper =
            new ObjectMapper();

    public static AIResponse analyze(AIRequest request) {

        try {

            String json = mapper.writeValueAsString(request);
            String baseUrl = System.getenv().getOrDefault("AI_SERVICE_URL", DEFAULT_BASE_URL);

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + ANALYSIS_PATH))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                     .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status: " + response.statusCode());
            System.out.println("Raw response: " + response.body());

            // Only parse if status is 200 and body looks like JSON
            if (response.statusCode() == 200 && response.body().trim().startsWith("{")) {
                return mapper.readValue(response.body(), AIResponse.class);
            } else {
                throw new RuntimeException("Unexpected response: " + response.body());
            }

        } catch (Exception e) {
            throw new RuntimeException("Error calling AI service", e);
        }

    }

}
