package com.example.desafiospringdatajpa.services;

import com.example.desafiospringdatajpa.entities.DTOs.MatriculaDTO;
import com.example.desafiospringdatajpa.entities.models.Aluno;
import com.example.desafiospringdatajpa.entities.models.Matricula;
import com.example.desafiospringdatajpa.repositories.MatriculaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService{

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoServiceImpl alunoServiceImpl;

    @Override
    public Matricula create(MatriculaDTO matriculaDTO) {
        Aluno aluno = alunoServiceImpl.getAluno(matriculaDTO.getAlunoId());
        Matricula matricula = new Matricula(aluno);

        return matriculaRepository.save(matricula);
    }

    @Override
    @SneakyThrows
    public Matricula get(Long id) {
        Optional<Matricula> matricula = this.matriculaRepository.findById(id);
        if (matricula.isEmpty()) throw new EntityNotFoundException();
        return matricula.get();
    }

    @Override
    public List<Matricula> getAll(String bairro) {

        if(bairro == null){
            return matriculaRepository.findAll();
        }else{
            return matriculaRepository.findAlunosMatriculadosBairro(bairro);
        }

    }

    @Override
    @SneakyThrows
    public void delete(Long id) {
        Optional<Matricula> matricula = this.matriculaRepository.findById(id);
        if (matricula.isEmpty()) throw new EntityNotFoundException();
        this.matriculaRepository.delete(matricula.get());
    }

    @Override
    public Matricula update(Long id, MatriculaDTO matriculaDTO) {
        Optional<Matricula> matricula = this.matriculaRepository.findById(id);
        if (matricula.isEmpty()) throw new EntityNotFoundException();
        return this.matriculaRepository.save(matricula.get());
    }

}
