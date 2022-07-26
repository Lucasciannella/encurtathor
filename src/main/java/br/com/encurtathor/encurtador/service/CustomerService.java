package br.com.encurtathor.encurtador.service;

import br.com.encurtathor.encurtador.dto.CustomerPostBody;
import br.com.encurtathor.encurtador.entity.Customer;
import br.com.encurtathor.encurtador.exception.BadRequestException;
import br.com.encurtathor.encurtador.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer findByIdOrThrowBadRequestException(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Customer do not Exist, try it"));
    }

    public Customer createUser(CustomerPostBody customerPostBody) {

        Customer customer = Customer.builder()
                .name(customerPostBody.getName().trim())
                .email(customerPostBody.getEmail().trim())
                .password(customerPostBody.getPassword().trim())
                .date(LocalDate.now())
                .build();

        return customerRepository.save(customer);
    }
}