package be.jimsa.restapisconsuming.ws.service.impl;

import be.jimsa.restapisconsuming.ws.model.request.PersonRequest;
import be.jimsa.restapisconsuming.ws.service.RestTemplateService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    private final RestTemplate restTemplate;

    public RestTemplateServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<PersonRequest> getPeople() {
        String url = "http://localhost:8090/springapp/api/person";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "application/json");

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), List.class).getBody();
    }
}
