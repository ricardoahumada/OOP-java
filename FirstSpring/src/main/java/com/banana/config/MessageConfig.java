package com.banana.config;

import com.banana.modelos.IMessage;
import com.banana.modelos.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    @Bean
    public IMessage createMessage(){
        IMessage mess= new Message();
        mess.setMessage("Hola! Esto es un mensaje...");
        return mess;
    }
}
