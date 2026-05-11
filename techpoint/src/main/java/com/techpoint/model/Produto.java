package com.techpoint.model;

import jakarta.persistence.*;
import lombok.*;        // importante

@Entity
@Data                // gera getters, setters, equals, toString
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Integer estoque;
}
