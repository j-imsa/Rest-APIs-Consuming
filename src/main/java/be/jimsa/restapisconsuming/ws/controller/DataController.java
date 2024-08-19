package be.jimsa.restapisconsuming.ws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

    @GetMapping("/feign")
    public String getDataByFeign() {
        return "getDataByFeign";
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
