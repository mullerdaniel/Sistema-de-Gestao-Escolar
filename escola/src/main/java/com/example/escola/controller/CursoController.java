package com.example.escola.controller;

import com.example.escola.model.Curso;
import com.example.escola.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }


    @PostMapping
    public Curso salvarCurso(@RequestBody Curso curso) {
        try {
            return cursoService.salvarCurso(curso);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping
    public List<Curso> listarCurso() {
        try {
            return cursoService.listarCurso();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public Curso buscarCursoPorId(@PathVariable int id) {
        try {
            return cursoService.buscarCursoPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public void deletarCurso(@PathVariable int id) {
        try {
            cursoService.deletarCursoPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public Curso atualizarCurso(@PathVariable int id, @RequestBody Curso curso) {
        try {
            return cursoService.atualizarCurso(curso, id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}