package com.banana;

import com.banana.modelos.IMessage;
import com.banana.modelos.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class AppXMLContextTest {

    @Test
    public void createContext() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        assertNotNull(ctx);

        IMessage mess = (IMessage) ctx.getBean("aMessage");
        assertNotNull(mess);

        System.out.println(mess);
        mess.setMessage("Hola!");
        mess.convertMessage();
        System.out.println(mess);

        IMessage smess = (IMessage) ctx.getBean("secMessage");
        assertNotNull(smess);

        System.out.println(smess);
        System.out.println(smess.convertMessage());

        ctx.close();

    }

    @Test
    public void createContext2() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        assertNotNull(ctx);

        User user = ctx.getBean(User.class);
        assertNotNull(user);

        System.out.println(user);
//        user.getMensaje().convertMessage();
        System.out.println(user);

        ctx.close();

    }

}