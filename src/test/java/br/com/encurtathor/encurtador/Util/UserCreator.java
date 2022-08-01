package br.com.encurtathor.encurtador.Util;

import br.com.encurtathor.encurtador.entity.Customer;

import java.time.LocalDate;

public class UserCreator {

    public static Customer createUserToBeSaved() {
        return Customer.builder()
                .name("jack")
                .email("jack@hotmail.com")
                .password("Jack123")
                .date(LocalDate.now())
                .build();
    }

    public static Customer createValidUser() {
        return Customer.builder()
                .id(1L)
                .name("jack")
                .email("jack@hotmail.com")
                .password("Jack123")
                .date(LocalDate.now())
                .build();
    }
}