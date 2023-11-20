package com.myshoppingcart.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.myshoppingcart.persistence", "com.myshoppingcart.service"})
public class SpringConfig {
}
