package dev.berke.app.charging_station;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ChargingStationService {

    private final RestTemplate restTemplate;

    @Value("${rapidapi.host}")
    private String rapidApiHost;

    @Value("${rapidapi.key}")
    private String rapidApiKey;

    public String fetchChargingStations(String location, int limit) {
        String url = String.format(
                "https://%s/search-by-location?near=%s&limit=%d",
                rapidApiHost, location, limit);
        // Set headers
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.set("x-rapidapi-host", rapidApiHost);
        headers.set("x-rapidapi-key", rapidApiKey);
        org.springframework.http.HttpEntity<String> entity = new org.springframework.http.HttpEntity<>(headers);
        // Fetch data
        return restTemplate.exchange(
                url,
                org.springframework.http.HttpMethod.GET,
                entity,
                String.class).getBody();
    }

}