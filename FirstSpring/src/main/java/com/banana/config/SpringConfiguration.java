package com.banana.config;

import com.banana.modelos.Message;
import com.banana.modelos.SecretMessage;
import com.banana.modelos.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan(basePackages = {"com.banana.modelos"})
@Import({Message.class, SecretMessage.class, User.class})
public class SpringConfiguration {
}
