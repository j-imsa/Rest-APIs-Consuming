package be.jimsa.restapisconsuming.ws.service.impl;

import be.jimsa.restapisconsuming.ws.model.request.PersonRequest;
import be.jimsa.restapisconsuming.ws.service.WebClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class WebClientServiceImpl implements WebClientService {

    private final WebClient webClient;

    public WebClientServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Flux<PersonRequest> getPeople() {
        String url = "http://localhost:8090/springapp/api/person";
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToFlux(PersonRequest.class);
    }
}
