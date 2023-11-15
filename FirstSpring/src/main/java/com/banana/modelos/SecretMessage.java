package com.banana.modelos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
