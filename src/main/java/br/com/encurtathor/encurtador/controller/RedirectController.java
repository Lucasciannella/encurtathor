package br.com.encurtathor.encurtador.controller;

import br.com.encurtathor.encurtador.dto.RedirectCreationRequest;
import br.com.encurtathor.encurtador.entity.Redirects;
import br.com.encurtathor.encurtador.service.RedirectService;
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
public class RedirectController {

    private final RedirectService redirectService;

    @GetMapping("/{hash}")
    public ResponseEntity<?> handleRedirect(@PathVariable String hash) throws URISyntaxException {
        Redirects redirect = redirectService.getRedirect(hash);
        URI uri = new URI(redirect.getLongUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping("/url/create")
    public ResponseEntity<?> createRedirect(@Valid @RequestBody RedirectCreationRequest redirectCreationRequest) {
        return ResponseEntity.ok(redirectService.createRedirect(redirectCreationRequest));
    }
}
