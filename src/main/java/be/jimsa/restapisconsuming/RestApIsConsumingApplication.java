package be.jimsa.restapisconsuming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestApIsConsumingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApIsConsumingApplication.class, args);
    }

}
