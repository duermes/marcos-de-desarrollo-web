package com.mddw.readers.THE_READERS;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init() {
        return (args) -> {
            System.out.println("Application started successfully, enter at http://localhost:8070");
        };
    }

//    @GetMapping("/")
//    public String Mensaje() {
//        return "<h1 style='color: rgb(0, 0, 255);'> Hola Mundo! </h1>";
//    }
}