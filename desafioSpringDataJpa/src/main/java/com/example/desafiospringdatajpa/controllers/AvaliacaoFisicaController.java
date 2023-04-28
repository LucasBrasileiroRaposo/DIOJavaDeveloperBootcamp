package com.example.desafiospringdatajpa.controllers;

import com.example.desafiospringdatajpa.entities.DTOs.AvaliacaoFisicaDTO;
import com.example.desafiospringdatajpa.entities.models.AvaliacaoFisica;
import com.example.desafiospringdatajpa.services.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl avaliacaoFisicaService;

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaDTO avaliacaoFisicaDTO) {
        return avaliacaoFisicaService.create(avaliacaoFisicaDTO);
    }

    @GetMapping("/{id}")
    public AvaliacaoFisica getOne(@PathVariable Long id) {
        return avaliacaoFisicaService.get(id);
    }
    @GetMapping
    public List<AvaliacaoFisica> getAll(){
        return avaliacaoFisicaService.getAll();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        avaliacaoFisicaService.delete(id);
    }

}
