package com.example.escola.controller;

import com.example.escola.model.Nota;
import com.example.escola.service.NotaService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/nota")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }


    @PostMapping
    public Nota salvarNota(@RequestBody Nota nota) {
        try {
            return notaService.salvarNota(nota);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping
    public List<Nota> listarNota() {
        try {
            return notaService.listarNota();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public Nota buscarNotaPorId(@PathVariable int id) {
        try {
            return notaService.buscarNotaPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public void deletarNota(@PathVariable int id) {
        try {
            notaService.deletarNotaPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public Nota atualizarNota(@PathVariable int id, @RequestBody Nota nota) {
        try {
            return notaService.atualizarNota(nota, id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}