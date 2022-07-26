package br.com.encurtathor.encurtador.controller;

import br.com.encurtathor.encurtador.dto.ShortnerPostBody;
import br.com.encurtathor.encurtador.entity.Shortner;
import br.com.encurtathor.encurtador.service.ShortnerService;
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
@Tag(name = "Encurtador")
@CrossOrigin(originPatterns = "*")
public class ShortnerController {

    private final ShortnerService shortnerService;

    @GetMapping("/{hash}")
    @Operation(summary = "Redirecionar para a url encurtada passando o hash criado")
    public ResponseEntity<Shortner> handleRedirect(@PathVariable String hash) throws URISyntaxException {
        Shortner redirect = shortnerService.getRedirect(hash);
        URI uri = new URI(redirect.getLongUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping("/url/shorten")
    @Operation(summary = "Encurtar Url criando o hash manualmente")
    public ResponseEntity<Shortner> createRedirect(@Valid @RequestBody ShortnerPostBody shortnerPostBody) {
        return new ResponseEntity(shortnerService.createRedirect(shortnerPostBody), HttpStatus.CREATED);
    }
}