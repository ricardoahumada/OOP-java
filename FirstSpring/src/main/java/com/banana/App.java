package com.banana;

import com.banana.modelos.IMessage;
import com.banana.modelos.SecretMessage;
import com.banana.modelos.User;

public class App {
    public static void main(String[] args) {
        System.out.println("FIRST SPRING APP");

//        IMessage mess = new Message("Hola mundo!!");
        IMessage mess = new SecretMessage();

        User aUser= new User();

        aUser.setMensaje(mess);
        aUser.getMensaje().convertMessage();

        System.out.println(aUser);
    }
}
