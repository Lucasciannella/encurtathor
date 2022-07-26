package br.com.encurtathor.encurtador.Util;

import br.com.encurtathor.encurtador.dto.CustomerPostBody;

public class UserPostBodyCreator {
    public static CustomerPostBody createUserPostBody(){
        return CustomerPostBody.builder()
                .name(UserCreator.createUserToBeSaved().getName())
                .email(UserCreator.createUserToBeSaved().getEmail())
                .password(UserCreator.createUserToBeSaved().getPassword())
                .build();
    }
}