package br.com.encurtathor.encurtador.controller;

import br.com.encurtathor.encurtador.dto.UserPostBody;
import br.com.encurtathor.encurtador.entity.User;
import br.com.encurtathor.encurtador.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
@Tag(name = "Usuários")
@CrossOrigin(originPatterns = "*")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @Operation(summary = "Busca  o usuário pelo id")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    @Operation(summary = "Cria cadastro do usuário")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserPostBody userPostBody) {
        return new ResponseEntity(userService.createUser(userPostBody), HttpStatus.CREATED);
    }
}
