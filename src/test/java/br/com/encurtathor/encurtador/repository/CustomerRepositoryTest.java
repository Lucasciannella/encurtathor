package br.com.encurtathor.encurtador.repository;

import br.com.encurtathor.encurtador.entity.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
@DisplayName("Customer repository Test")
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("Save creates Customers when successful ")
    void save_peristence_whenSuccessful() {
        Customer customerToBeSaved = createCustomer();

        Customer savedCustomer = this.customerRepository.save(customerToBeSaved);

        Assertions.assertThat(savedCustomer).isNotNull();
        Assertions.assertThat(savedCustomer.getId()).isNotNull();
        Assertions.assertThat(savedCustomer.getName()).isEqualTo(customerToBeSaved.getName());
        Assertions.assertThat(savedCustomer.getEmail()).isEqualTo(customerToBeSaved.getEmail());
        Assertions.assertThat(savedCustomer.getPassword()).isEqualTo(customerToBeSaved.getPassword());
        Assertions.assertThat(savedCustomer.getDate()).isEqualTo(customerToBeSaved.getDate());
    }

    private Customer createCustomer() {
        return Customer.builder()
                .name("Lucas")
                .email("Lucas@gmail.com")
                .password("XR23131")
                .date(LocalDate.now())
                .build();
    }
}