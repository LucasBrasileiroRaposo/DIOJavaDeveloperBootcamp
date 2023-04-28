package com.example.desafiospringdatajpa.entities.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "avaliacoes_fisicas")
public class AvaliacaoFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    // nesse caso em especifico o nome da coluna já seria esse, mesmo sem essa anotação
    // foi usada só para mostrar o exemplo da anotação
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

    @Column(name="peso_atual")
    private double peso;

    @Column(name="altura_atual")
    private double altura;

    public AvaliacaoFisica(Aluno aluno, double peso, double altura) {
        this.aluno = aluno;
        this.altura = altura;
        this.peso = peso;
    }
}