package be.jimsa.restapisconsuming.ws.service;

import be.jimsa.restapisconsuming.ws.model.request.PersonRequest;

import java.util.List;

public interface RestTemplateService {
    List<PersonRequest> getPeople();
}
