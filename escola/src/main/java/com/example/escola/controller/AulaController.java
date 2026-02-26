package com.example.escola.controller;

import com.example.escola.model.Aula;
import com.example.escola.service.AulaService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/aula")
public class AulaController {

    private final AulaService aulaService;

    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }


    @PostMapping
    public Aula salvarAula(@RequestBody Aula aula) {
        try {
            return aulaService.salvarAula(aula);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping
    public List<Aula> listarAula() {
        try {
            return aulaService.listarAula();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public Aula buscarAulaPorId(@PathVariable int id) {
        try {
            return aulaService.buscarAulaPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public void deletarAula(@PathVariable int id) {
        try {
            aulaService.deletarAulaPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public Aula atualizarAula(@PathVariable int id, @RequestBody Aula aula) {
        try {
            return aulaService.atualizarAula(aula, id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}