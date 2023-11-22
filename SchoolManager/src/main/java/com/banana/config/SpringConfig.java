package com.banana.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ReposConfig.class, ServicesConfig.class})
@ComponentScan(basePackages = {"com.banana.persistence", "com.banana.services"})
//@Import({StudentsRepository.class, StudentsService.class})
public class SpringConfig {
    
}
