package be.jimsa.restapisconsuming.ws.controller;

import be.jimsa.restapisconsuming.ws.model.request.PersonRequest;
import be.jimsa.restapisconsuming.ws.proxy.DataProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {

    private final DataProxy dataProxy;

    public DataController(DataProxy dataProxy) {
        this.dataProxy = dataProxy;
    }

    @GetMapping("/feign")
    public ResponseEntity<List<PersonRequest>> getDataByFeign() {
        return ResponseEntity.ok(dataProxy.getPeople());
    }

    @GetMapping("/template")
    public String getDataByRestTemplate() {
        return "getDataByRestTemplate";
    }

    @GetMapping("/client")
    public String getDataByWebClient() {
        return "getDataByWebClient";
    }
}
