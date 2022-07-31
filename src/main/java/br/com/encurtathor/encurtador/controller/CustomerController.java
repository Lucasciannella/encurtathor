package br.com.encurtathor.encurtador.controller;

import br.com.encurtathor.encurtador.dto.CustomerPostBody;
import br.com.encurtathor.encurtador.entity.Customer;
import br.com.encurtathor.encurtador.service.CustomerService;
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
@Tag(name = "Customers")
@CrossOrigin(originPatterns = "*")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    @Operation(summary = "Find Customer by id")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    @Operation(summary = "Create user registration")
    public ResponseEntity<Customer> createUser(@RequestBody @Valid CustomerPostBody customerPostBody) {
        return new ResponseEntity(customerService.createUser(customerPostBody), HttpStatus.CREATED);
    }
}