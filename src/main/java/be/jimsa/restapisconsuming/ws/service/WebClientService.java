package be.jimsa.restapisconsuming.ws.service;

import be.jimsa.restapisconsuming.ws.model.request.PersonRequest;
import reactor.core.publisher.Flux;

public interface WebClientService {
    Flux<PersonRequest> getPeople();
}
