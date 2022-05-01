package com.weedoogift.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.weedoogift.*"})
@EnableJpaRepositories(basePackages = {"com.weedoogift.infra.persistence"})
@ComponentScan(basePackages = {"com.weedoogift.*"})
@EntityScan("com.weedoogift.infra.model")
@ConfigurationPropertiesScan
public class WeeDooGiftApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeeDooGiftApplication.class, args);
    }


}