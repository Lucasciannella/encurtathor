package br.com.encurtathor.encurtador.controller;

import br.com.encurtathor.encurtador.dto.RedirectCreationRequest;
import br.com.encurtathor.encurtador.entity.Redirects;
import br.com.encurtathor.encurtador.service.RedirectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
@Tag(name = "Encurtathor Api")
public class RedirectController {

    private final RedirectService redirectService;

    @GetMapping("/{hash}")
    @Operation(summary = "Redirecionar para a url encurtada passando o hash criado")
    public ResponseEntity<?> handleRedirect(@PathVariable String hash) throws URISyntaxException {
        Redirects redirect = redirectService.getRedirect(hash);
        URI uri = new URI(redirect.getLongUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping("/url/create")
    @Operation(summary = "Encurtar Url criando o hash manualmente")
    public ResponseEntity<?> createRedirect(@Valid @RequestBody RedirectCreationRequest redirectCreationRequest) {
        return new ResponseEntity(redirectService.createRedirect(redirectCreationRequest), HttpStatus.CREATED);
    }
}