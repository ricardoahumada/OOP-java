package com.banana;

import com.banana.modelos.Message;
import com.banana.modelos.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/beans.xml");

        try {

            Message obj = (Message) context.getBean("aMessage");
            String mss = obj.getMessage();
            System.out.println("Your Message : " + mss);

            // Usuario user = (Usuario) context.getBean("aUser");
            User user = context.getBean(User.class);
            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
