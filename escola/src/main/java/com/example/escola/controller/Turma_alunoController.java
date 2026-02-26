package com.example.escola.controller;

import com.example.escola.repository.Turma_alunoRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/turma-aluno")
public class Turma_alunoController {

    private final Turma_alunoRepository repository;

    public Turma_alunoController(Turma_alunoRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/{turma_id}/{aluno_id}")
    public String salvar(
            @PathVariable int turma_id,
            @PathVariable int aluno_id) {

        try {
            repository.salvarTurma_aluno(turma_id, aluno_id);
            return "Aluno matriculado com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @DeleteMapping("/{turma_id}/{aluno_id}")
    public String remover(
            @PathVariable int turma_id,
            @PathVariable int aluno_id) {

        try {
            repository.remover(turma_id, aluno_id);
            return "Aluno removido da turma com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping("/turma/{turma_id}")
    public List<Integer> buscarAlunosPorTurma(@PathVariable int turma_id) {

        try {
            return repository.buscarAlunosPorTurma(turma_id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping("/aluno/{aluno_id}")
    public List<Integer> buscarTurmasPorAluno(@PathVariable int aluno_id) {

        try {
            return repository.buscarTurmasPorAluno(aluno_id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @DeleteMapping("/turma/{turma_id}")
    public String removerTodosAlunosDaTurma(@PathVariable int turma_id) {

        try {
            repository.removerTodosAlunosDaTurma(turma_id);
            return "Todos os alunos foram removidos da turma!";
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @DeleteMapping("/aluno/{aluno_id}")
    public String removerAlunoDeTodasTurmas(@PathVariable int aluno_id) {

        try {
            repository.removerAlunoDeTodasTurmas(aluno_id);
            return "Aluno removido de todas as turmas!";
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}