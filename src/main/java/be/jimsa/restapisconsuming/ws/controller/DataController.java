package be.jimsa.restapisconsuming.ws.controller;

import be.jimsa.restapisconsuming.ws.model.request.PersonRequest;
import be.jimsa.restapisconsuming.ws.proxy.DataProxy;
import be.jimsa.restapisconsuming.ws.service.RestTemplateService;
import be.jimsa.restapisconsuming.ws.service.WebClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {

    private final DataProxy dataProxy;
    private final RestTemplateService restTemplateService;
    private final WebClientService webClientService;

    public DataController(DataProxy dataProxy, RestTemplateService restTemplateService, WebClientService webClientService) {
        this.dataProxy = dataProxy;
        this.restTemplateService = restTemplateService;
        this.webClientService = webClientService;
    }

    @GetMapping("/feign")
    public ResponseEntity<List<PersonRequest>> getDataByFeign() {
        return ResponseEntity.ok(dataProxy.getPeople());
    }

    @GetMapping("/template")
    public ResponseEntity<List<PersonRequest>> getDataByRestTemplate() {
        return ResponseEntity.ok(restTemplateService.getPeople());
    }

    @GetMapping("/client")
    public ResponseEntity<Flux<PersonRequest>> getDataByWebClient() {
        return ResponseEntity.ok(webClientService.getPeople());
    }
}
