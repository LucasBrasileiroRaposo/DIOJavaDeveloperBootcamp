package com.example.desafiospringdatajpa.entities.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "matriculas")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    private LocalDateTime dataDaMatricula;

    public Matricula (Aluno aluno) {
        this.aluno = aluno;
        this.dataDaMatricula = LocalDateTime.now();
    }
}
