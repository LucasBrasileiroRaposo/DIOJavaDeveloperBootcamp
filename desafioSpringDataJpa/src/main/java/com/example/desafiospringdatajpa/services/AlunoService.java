package com.example.desafiospringdatajpa.services;

import com.example.desafiospringdatajpa.entities.DTOs.AlunoDTO;
import com.example.desafiospringdatajpa.entities.models.Aluno;
import com.example.desafiospringdatajpa.entities.models.AvaliacaoFisica;

import java.util.List;

public interface AlunoService {
    public Aluno create(AlunoDTO alunoDTO);
    public Aluno update(Long id, AlunoDTO alunoDTO);
    public Aluno getAluno(Long id);
    public List<Aluno> getAll(String dataDeNacimento, String bairro);
    public void delete(Long id);
    public List<AvaliacaoFisica> getAllAvaliacoesFisicasDoAluno(Long id);
}
