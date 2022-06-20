package br.com.encurtathor.encurtador.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class RedirectCreationRequest {
    @NotNull
    private String hash;
    @NotNull
    private String longUrl;
}
