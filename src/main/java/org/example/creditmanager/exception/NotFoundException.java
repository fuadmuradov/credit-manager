package org.example.creditmanager.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException{
    private String code;
    public NotFoundException(String message, String code){
        super(message);
        this.code = code;
    }
}
