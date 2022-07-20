package br.com.encurtathor.encurtador.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ShortnerPostBody {
    @NotNull
    private String hash;
    @NotNull
    private String longUrl;
}