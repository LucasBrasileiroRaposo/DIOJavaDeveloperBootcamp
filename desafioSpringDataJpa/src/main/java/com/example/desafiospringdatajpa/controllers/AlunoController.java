package com.example.desafiospringdatajpa.controllers;

import com.example.desafiospringdatajpa.entities.DTOs.AlunoDTO;
import com.example.desafiospringdatajpa.entities.models.Aluno;
import com.example.desafiospringdatajpa.entities.models.AvaliacaoFisica;
import com.example.desafiospringdatajpa.services.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl alunoService;

    @PostMapping
    public Aluno createAluno(@RequestBody AlunoDTO alunoDTO) throws Exception {
        if (alunoDTO == null) throw new Exception(new IllegalAccessError());
        return alunoService.create(alunoDTO);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return alunoService.getAllAvaliacoesFisicasDoAluno(id);
    }

    @GetMapping("/{id}")
    public Aluno getAluno(@PathVariable Long id) {
        return alunoService.getAluno(id);
    }
    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNacimento,
                              @RequestParam(value = "bairro", required = false) String bairro){
        return alunoService.getAll(dataDeNacimento, bairro);
    }
    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable Long id) {
        alunoService.delete(id);
    }

}
