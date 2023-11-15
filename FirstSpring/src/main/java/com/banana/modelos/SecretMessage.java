package com.banana.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SecretMessage implements IMessage {
    private int code;

    @Override
    public void setMessage(String message) {

    }

    @Override
    public String convertMessage() {
        return "code:" + code;
    }
}
