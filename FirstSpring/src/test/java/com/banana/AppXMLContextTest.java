package com.banana;

import com.banana.modelos.IMessage;
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
//        mess.setMessage("Hola!");
        mess.convertMessage();
        System.out.println(mess);

    }

}