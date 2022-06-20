package br.com.encurtathor.encurtador.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Redirects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String hash;

    @Column(nullable = false)
    private String longUrl;

    @Column(nullable = false)
    private LocalDate dateCreated;
}