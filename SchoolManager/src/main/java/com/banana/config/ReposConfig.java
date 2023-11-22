package com.banana.config;

import com.banana.persistence.StudentsRepository;
import com.banana.persistence.StudentsRepositoryInf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReposConfig {

    @Bean
    public StudentsRepositoryInf getStudentsRepository() {
        StudentsRepository repo = new StudentsRepository();
        repo.setUrlConn("jdbc://.....");
        return repo;
    }

}