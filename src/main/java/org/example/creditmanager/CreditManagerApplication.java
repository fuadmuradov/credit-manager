package org.example.creditmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CreditManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditManagerApplication.class, args);
    }

}
