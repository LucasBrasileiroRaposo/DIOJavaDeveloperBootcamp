package com.example.desafiospringdatajpa.repositories;

import com.example.desafiospringdatajpa.entities.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findAllByBairro(String bairro);

    List<Aluno> findAllByDataDeNascimento(LocalDate dataDeNacimento);

    List<Aluno> findAllByBairroAndDataDeNascimento(LocalDate dataDeNascimento, String bairro);
}
