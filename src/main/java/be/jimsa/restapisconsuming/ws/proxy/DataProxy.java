package be.jimsa.restapisconsuming.ws.proxy;

import be.jimsa.restapisconsuming.ws.config.ProxyCallConfig;
import be.jimsa.restapisconsuming.ws.model.request.PersonRequest;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "data",
        url = "http://localhost:8090/springapp/api/person",
        configuration = ProxyCallConfig.class
)
public interface DataProxy {

    @GetMapping
    @Headers(value = "Content-Type: application/json")
    public List<PersonRequest> getPeople();
}
