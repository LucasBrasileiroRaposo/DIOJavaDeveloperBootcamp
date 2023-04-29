package com.example.desafiospringdatajpa.controllers;

import com.example.desafiospringdatajpa.entities.DTOs.MatriculaDTO;
import com.example.desafiospringdatajpa.entities.models.Matricula;
import com.example.desafiospringdatajpa.services.MatriculaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl matriculaService;

    @PostMapping
    public Matricula create(@Valid @RequestBody MatriculaDTO matriculaDTO) {
        return matriculaService.create(matriculaDTO);
    }

    @PutMapping("/{id}")
    public Matricula updateMatricula(@PathVariable Long id, @Valid @RequestBody MatriculaDTO matriculaDTO) {
        return matriculaService.update(id, matriculaDTO);
    }

    @GetMapping("/{id}")
    public Matricula getOne(@PathVariable Long id) {
        return this.matriculaService.get(id);
    }
    @GetMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
        return matriculaService.getAll(bairro);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        matriculaService.delete(id);
    }
}
