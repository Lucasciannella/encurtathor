package br.com.encurtathor.encurtador.repository;

import br.com.encurtathor.encurtador.entity.Redirects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RedirectsRepository extends JpaRepository<Redirects,Long> {
    Optional<Redirects> findByHash(String hash);

    Boolean existsByHash(String hash);
}