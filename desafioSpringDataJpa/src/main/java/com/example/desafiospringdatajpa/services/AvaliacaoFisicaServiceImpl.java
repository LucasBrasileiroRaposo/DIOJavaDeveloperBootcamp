package com.example.desafiospringdatajpa.services;

import com.example.desafiospringdatajpa.entities.DTOs.AvaliacaoFisicaDTO;
import com.example.desafiospringdatajpa.entities.DTOs.AvaliacaoFisicaUpdateDTO;
import com.example.desafiospringdatajpa.entities.models.Aluno;
import com.example.desafiospringdatajpa.entities.models.AvaliacaoFisica;
import com.example.desafiospringdatajpa.repositories.AvaliacaoFisicaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoFisicaServiceImpl implements AvaliacaoFisicaService{

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoServiceImpl alunoService;

    public AvaliacaoFisica create(AvaliacaoFisicaDTO avaliacaoFisicaDTO) {
        Aluno aluno = alunoService.getAluno(avaliacaoFisicaDTO.getAlunoId());
        AvaliacaoFisica newAvaliacaoFisica = new AvaliacaoFisica(
                aluno,
                avaliacaoFisicaDTO.getPeso(),
                avaliacaoFisicaDTO.getAltura()
        );
        return avaliacaoFisicaRepository.save(newAvaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        Optional<AvaliacaoFisica> avaliacaoFisica = this.avaliacaoFisicaRepository.findById(id);
        if (avaliacaoFisica.isEmpty()) throw new EntityNotFoundException();
        return avaliacaoFisica.get();
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateDTO avaliacaoFisicaUpdateDTO) {
        return new AvaliacaoFisica();
    }

    @Override
    public void delete(Long id) {
        Optional<AvaliacaoFisica> avaliacaoFisica = this.avaliacaoFisicaRepository.findById(id);
        if (avaliacaoFisica.isEmpty()) throw new EntityNotFoundException();
        avaliacaoFisicaRepository.delete(avaliacaoFisica.get());
    }
}
