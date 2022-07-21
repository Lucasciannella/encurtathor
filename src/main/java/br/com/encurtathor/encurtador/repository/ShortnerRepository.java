package br.com.encurtathor.encurtador.repository;

import br.com.encurtathor.encurtador.entity.Shortner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortnerRepository extends JpaRepository<Shortner, Long> {
    Optional<Shortner> findByHash(String hash);

    Boolean existsByHash(String hash);
}