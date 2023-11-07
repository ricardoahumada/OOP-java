package es.netmind.mypersonalbankapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class MyPersonalBankAPIApplication {
    private static final Logger logger = LoggerFactory.getLogger(MyPersonalBankAPIApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MyPersonalBankAPIApplication.class, args);
    }
}
