package com.banana.config;

import com.banana.modelos.IMessage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageConfigTest {
    @Test
    public void createMessage() {
        MessageConfig config = new MessageConfig();
        IMessage unMensaje = config.createMessage();
        assertEquals(unMensaje.getMessage(), "Hola! Esto es un mensaje...");
    }
}