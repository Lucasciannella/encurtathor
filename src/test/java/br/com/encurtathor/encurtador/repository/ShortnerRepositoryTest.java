package br.com.encurtathor.encurtador.repository;

import br.com.encurtathor.encurtador.entity.Shortner;
import com.fasterxml.jackson.databind.node.ShortNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
@DisplayName("Shortner repository tests")
class ShortnerRepositoryTest {

    @Autowired
    private ShortnerRepository shortnerRepository;

    @Test
    void save_persistence_WhenSuccessful() {
        Shortner shorthenToBeSaved = createShortner();

        Shortner savedShortner = shortnerRepository.save(shorthenToBeSaved);

        Assertions.assertThat(savedShortner).isNotNull();
        Assertions.assertThat(savedShortner.getId()).isNotNull();
        Assertions.assertThat(savedShortner.getLongUrl()).isEqualTo(shorthenToBeSaved.getLongUrl());
        Assertions.assertThat(savedShortner.getHash()).isEqualTo(shorthenToBeSaved.getHash());
        Assertions.assertThat(savedShortner.getDateCreated()).isEqualTo(shorthenToBeSaved.getDateCreated());

    }

    private Shortner createShortner(){
        return Shortner.builder()
                .hash("test")
                .longUrl("www.linkedin.com")
                .dateCreated(LocalDate.now())
                .build();
    }
}