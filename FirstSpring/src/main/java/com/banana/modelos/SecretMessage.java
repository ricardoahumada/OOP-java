package com.banana.modelos;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component("secMessage")
//@Named("secMessage")
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
