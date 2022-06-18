package br.com.encurtathor.encurtador.repository;

import br.com.encurtathor.encurtador.entity.Redirects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedirectsRepository extends JpaRepository<Redirects,Long> {
}
