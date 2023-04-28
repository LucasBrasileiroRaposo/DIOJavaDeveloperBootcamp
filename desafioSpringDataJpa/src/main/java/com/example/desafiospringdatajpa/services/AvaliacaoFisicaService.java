package com.example.desafiospringdatajpa.services;

import com.example.desafiospringdatajpa.entities.DTOs.AvaliacaoFisicaDTO;
import com.example.desafiospringdatajpa.entities.DTOs.AvaliacaoFisicaUpdateDTO;
import com.example.desafiospringdatajpa.entities.models.AvaliacaoFisica;

import java.util.List;

public interface AvaliacaoFisicaService {

    AvaliacaoFisica create(AvaliacaoFisicaDTO avaliacaoFisicaDTO);

    AvaliacaoFisica get(Long id);

    List<AvaliacaoFisica> getAll();

    AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateDTO avaliacaoFisicaUpdateDTO);

    void delete(Long id);
}
