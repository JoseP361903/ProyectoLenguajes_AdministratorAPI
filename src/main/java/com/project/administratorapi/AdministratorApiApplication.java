package com.project.administratorapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication @ComponentScan({"com.project.controller","com.project.service", "com.project.repository" })
@EntityScan( basePackages = {"com.*"})
@EnableJpaRepositories("com.project.repository")
public class AdministratorApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdministratorApiApplication.class, args);
    }

}
