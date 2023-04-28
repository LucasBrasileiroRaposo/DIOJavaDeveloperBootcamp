package com.example.desafiospringdatajpa.services;

import com.example.desafiospringdatajpa.entities.DTOs.AlunoDTO;
import com.example.desafiospringdatajpa.entities.models.Aluno;
import com.example.desafiospringdatajpa.entities.models.AvaliacaoFisica;
import com.example.desafiospringdatajpa.repositories.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno create(AlunoDTO alunoDTO) {
        Aluno newAluno = new Aluno(
                alunoDTO.getNome(),
                alunoDTO.getCpf(),
                alunoDTO.getBairro(),
                alunoDTO.getDataDeNascimento()
        );
        return alunoRepository.save(newAluno);
    }

    @Override
    public Aluno update(AlunoDTO alunoDTO) {
        return null;
    }

    @Override
    public Aluno getAluno(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isEmpty()) throw new EntityNotFoundException();
        return aluno.get();
    }

    @Override
    public List<Aluno> getAll(String dataDeNacimento, String bairro) {
        if (dataDeNacimento.isEmpty() && bairro.isEmpty()) return alunoRepository.findAll();
        else if (dataDeNacimento.isEmpty()) return alunoRepository.findAllByBairro(bairro);
        else if (bairro.isEmpty()) return alunoRepository.findAllByDataDeNascimento(LocalDate.parse(dataDeNacimento));
        return  alunoRepository.findAllByBairroAndDataDeNascimento(LocalDate.parse(dataDeNacimento), bairro);
    }

    @Override
    public void delete(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isEmpty()) throw new EntityNotFoundException();
        alunoRepository.delete(aluno.get());
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacoesFisicasDoAluno(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isEmpty()) throw new EntityNotFoundException();
        return aluno.get().getAvaliacoes();
    }
}
