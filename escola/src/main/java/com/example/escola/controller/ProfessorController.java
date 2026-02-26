package com.example.escola.controller;

import com.example.escola.model.Professor;
import com.example.escola.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }


    @PostMapping
    public Professor salvarProfessor(@RequestBody Professor professor) {
        try {
            return professorService.salvarProfessor(professor);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping
    public List<Professor> listarProfessor() {
        try {
            return professorService.listarProfessor();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public Professor buscarProfessorPorId(@PathVariable int id) {
        try {
            return professorService.buscarProfessorPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable int id) {
        try {
            professorService.deletarProfessorPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public Professor atualizarProfessor(@PathVariable int id, @RequestBody Professor professor) {
        try {
            return professorService.atualizarProfessor(professor, id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}