package com.mvp.surf_api.controller;

import com.mvp.surf_api.model.SessaoSurf;
import com.mvp.surf_api.repository.SessaoSurfRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessoes")
@CrossOrigin(origins = "*")
public class SessaoSurfController {

    private final SessaoSurfRepository repository;

    public SessaoSurfController(SessaoSurfRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<SessaoSurf> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public SessaoSurf criar(@RequestBody SessaoSurf sessao) {
        return repository.save(sessao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}