package com.banana.modelos;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Message implements IMessage {
    private String message;

    @Override
    public String convertMessage() {
        this.message = this.message.toUpperCase();
        return this.message;
    }
}
