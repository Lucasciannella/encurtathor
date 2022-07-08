package br.com.encurtathor.encurtador.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserPostBody {

    @NotNull
    private String name;

    @NotNull
    @Email(regexp = ".+[@].+[\\.].+")
    private String email;

    @NotNull
    private String password;
}