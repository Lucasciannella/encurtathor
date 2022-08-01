package br.com.encurtathor.encurtador.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotFoundExceptionDetails { private String title;
    private int status;
    private String details;
    private String developerMessage;
    private LocalDateTime timeStamp;
}
