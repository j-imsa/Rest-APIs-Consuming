package be.jimsa.restapisconsuming.ws.controller;

import be.jimsa.restapisconsuming.ws.model.request.PersonRequest;
import be.jimsa.restapisconsuming.ws.proxy.DataProxy;
import be.jimsa.restapisconsuming.ws.service.RestTemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {

    private final DataProxy dataProxy;
    private final RestTemplateService restTemplateService;

    public DataController(DataProxy dataProxy, RestTemplateService restTemplateService) {
        this.dataProxy = dataProxy;
        this.restTemplateService = restTemplateService;
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
    public String getDataByWebClient() {
        return "getDataByWebClient";
    }
}
