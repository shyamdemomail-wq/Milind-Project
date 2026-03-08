package com.insurance.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class InsuranceAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceAiApplication.class, args);
    }
}
