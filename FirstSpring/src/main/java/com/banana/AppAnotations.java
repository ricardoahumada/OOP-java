package com.banana;

import com.banana.config.FirstConfiguration;
import com.banana.modelos.Message;
import com.banana.modelos.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppAnotations {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(FirstConfiguration.class);


        // Message obj = (Message) context.getBean("unMensaje");
        Message obj = context.getBean(Message.class);
        System.out.println(obj);

        User user = context.getBean(User.class);
        System.out.println(user);

    }
}
