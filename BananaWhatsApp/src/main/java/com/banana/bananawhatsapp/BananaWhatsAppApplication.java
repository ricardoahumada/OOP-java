package com.banana.bananawhatsapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BananaWhatsAppApplication {
    private static final Logger logger = LoggerFactory.getLogger(BananaWhatsAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BananaWhatsAppApplication.class, args);
    }
}
