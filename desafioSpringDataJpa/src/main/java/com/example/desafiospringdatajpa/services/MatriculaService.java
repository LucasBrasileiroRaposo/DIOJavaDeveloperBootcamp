package com.example.desafiospringdatajpa.services;

import com.example.desafiospringdatajpa.entities.DTOs.MatriculaDTO;
import com.example.desafiospringdatajpa.entities.models.Matricula;

import java.util.List;

public interface MatriculaService {
    Matricula create(MatriculaDTO matriculaDTO);

    Matricula get(Long id);

    List<Matricula> getAll(String bairro);

    void delete(Long id);

    Matricula update(Long id, MatriculaDTO matriculaDTO);
}
