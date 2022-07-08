package br.com.encurtathor.encurtador.controller;

import br.com.encurtathor.encurtador.dto.UserPostBody;
import br.com.encurtathor.encurtador.entity.User;
import br.com.encurtathor.encurtador.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserPostBody userPostBody){
        return new ResponseEntity(userService.createUser(userPostBody), HttpStatus.CREATED);
    }
}
