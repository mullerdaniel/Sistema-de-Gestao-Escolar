package com.example.escola.service;

import com.example.escola.repository.Turma_alunoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class Turma_alunoService {

    private final Turma_alunoRepository turmaAlunoRepository;

    public Turma_alunoService(Turma_alunoRepository turmaAlunoRepository) {
        this.turmaAlunoRepository = turmaAlunoRepository;
    }


    public void adicionar(int turma_id, int aluno_id) throws SQLException {
        turmaAlunoRepository.salvarTurma_aluno(turma_id, aluno_id);
    }


    public void remover(int turma_id, int aluno_id) throws SQLException {
        turmaAlunoRepository.remover(turma_id, aluno_id);
    }


    public List<Integer> buscarAlunosPorTurma(int turma_id) throws SQLException {
        return turmaAlunoRepository.buscarAlunosPorTurma(turma_id);
    }


    public List<Integer> buscarTurmasPorAluno(int aluno_id) throws SQLException {
        return turmaAlunoRepository.buscarTurmasPorAluno(aluno_id);
    }
}