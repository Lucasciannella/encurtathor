package br.com.encurtathor.encurtador.repository;

import br.com.encurtathor.encurtador.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
