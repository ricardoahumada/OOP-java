package com.banana.config;

import com.banana.modelos.Message;
import com.banana.modelos.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

@Configuration
public class UserConfig {
    @Inject
    Message unMensaje;

    @Bean
    public User createUser(){
        User user= new User();
        user.setEmail("r@r.com");
        user.setNombre("Ricardo");
        user.setMensaje(unMensaje);
        return user;
    }
}
