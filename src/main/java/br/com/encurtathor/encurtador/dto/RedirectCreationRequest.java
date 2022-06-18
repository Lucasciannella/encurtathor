package br.com.encurtathor.encurtador.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RedirectCreationRequest {
    private String hash;
    private String longUrl;
    private LocalDate dateCreated;
}
