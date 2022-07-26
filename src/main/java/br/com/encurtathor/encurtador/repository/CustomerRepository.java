package br.com.encurtathor.encurtador.repository;

import br.com.encurtathor.encurtador.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
