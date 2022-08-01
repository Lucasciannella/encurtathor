package br.com.encurtathor.encurtador.handler;

import br.com.encurtathor.encurtador.exception.BadRequestException;
import br.com.encurtathor.encurtador.exception.BadRequestExceptionDetails;
import br.com.encurtathor.encurtador.exception.NotFoundException;
import br.com.encurtathor.encurtador.exception.NotFoundExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException badRequestException){
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .timeStamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, Check the documentation")
                        .details(badRequestException.getMessage())
                        .developerMessage(badRequestException.getClass().getName())
                        .build(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<NotFoundExceptionDetails> handlerNotFoundException(NotFoundException notFoundException){
        return new ResponseEntity<>(NotFoundExceptionDetails.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Not Found Exception, Check the documentation")
                .details(notFoundException.getMessage())
                .developerMessage(notFoundException.getClass().getName())
                .build(), HttpStatus.NOT_FOUND);
    }
}