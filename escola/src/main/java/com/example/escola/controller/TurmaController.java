package com.example.escola.controller;

import com.example.escola.model.Turma;
import com.example.escola.service.TurmaService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }


    @PostMapping
    public Turma salvarTurma(@RequestBody Turma turma) {
        try {
            return turmaService.salvarTurma(turma);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping
    public List<Turma> listarTurma() {
        try {
            return turmaService.listarTurma();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public Turma buscarTurmaPorId(@PathVariable int id) {
        try {
            return turmaService.buscarTurmaPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public void deletarTurma(@PathVariable int id) {
        try {
            turmaService.deletarTurmaPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public Turma atualizarTurma(@PathVariable int id, @RequestBody Turma turma) {
        try {
            return turmaService.atualizarTurma(turma, id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}