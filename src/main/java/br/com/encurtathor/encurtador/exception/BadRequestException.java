package br.com.encurtathor.encurtador.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class BadRequestException extends RuntimeException {
    public BadRequestException(String  message){
        super(message);
    }
    public BadRequestException(String message, Throwable cause){
        super(message,cause);
    }

}
