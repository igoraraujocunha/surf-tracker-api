package com.mvp.surf_api.controller;

import com.mvp.surf_api.model.SessaoSurf;
import com.mvp.surf_api.repository.SessaoSurfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sessoes")
@CrossOrigin(origins = "*") // Essencial para o Next.js conseguir consumir essa API
public class SessaoSurfController {

    @Autowired
    private SessaoSurfRepository repository;

    @GetMapping
    public List<SessaoSurf> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public SessaoSurf criar(@RequestBody SessaoSurf sessao) {
        return repository.save(sessao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SessaoSurf> atualizar(@PathVariable Long id, @RequestBody SessaoSurf detalhesSessao) {
        return repository.findById(id)
                .map(sessao -> {
                    sessao.setPraia(detalhesSessao.getPraia());
                    sessao.setDataSessao(detalhesSessao.getDataSessao());
                    sessao.setTamanhoOnda(detalhesSessao.getTamanhoOnda());
                    sessao.setNota(detalhesSessao.getNota());
                    SessaoSurf atualizado = repository.save(sessao);
                    return ResponseEntity.ok().body(atualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return repository.findById(id)
                .map(sessao -> {
                    repository.delete(sessao);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}