package com.banana.modelos;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@Component("aMessage")
@Named("aMessage")
public class Message implements IMessage {
    private String message;

    @Override
    public String convertMessage() {
        this.message = this.message.toUpperCase();
        return this.message;
    }
}
