package br.com.encurtathor.encurtador.repository;

import br.com.encurtathor.encurtador.entity.Redirects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RedirectsRepository extends JpaRepository<Redirects,Long> {
    Optional<Redirects> findByHash(String hash);

    boolean existedByHash(String hash);
}
