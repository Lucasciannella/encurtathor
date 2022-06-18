package br.com.encurtathor.encurtador.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Data
public class Redirects {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String hash;
    @Column
    private String longUrl;
    @Column(nullable = false,unique = true)
    private LocalDate dateCreated;
}
