package com.banana.config;

import com.banana.persistence.StudentsRepository;
import com.banana.services.StudentsServiceI;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan(basePackages = {"com.banana.persistence", "com.banana.services"})
@Import({StudentsRepository.class, StudentsServiceI.class})
public class SpringConfig {
}
