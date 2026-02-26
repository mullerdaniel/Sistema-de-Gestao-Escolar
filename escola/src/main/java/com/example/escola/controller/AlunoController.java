package com.example.escola.controller;

import com.example.escola.dto.AlunoRequisicaoDto;
import com.example.escola.dto.AlunoRespostaDto;
import com.example.escola.model.Aluno;
import com.example.escola.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    @PostMapping
    public AlunoRespostaDto salvarAluno(@RequestBody AlunoRequisicaoDto dto) {
        try {
            return alunoService.salvarAluno(dto);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping
    public List<Aluno> listarAluno() {
        try {
            return alunoService.listarAluno();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public Aluno buscarAlunoPorId(@PathVariable int id) {
        try {
            return alunoService.buscarAlunoPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable int id) {
        try {
            alunoService.deletarAlunoPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable int id, @RequestBody Aluno aluno) {
        try {
            return alunoService.atualizarAluno(aluno, id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}