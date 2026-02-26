package com.example.escola.service;

import com.example.escola.model.Turma;
import com.example.escola.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }


    public Turma salvarTurma(Turma turma) throws SQLException {
        return turmaRepository.salvarTurma(turma);
    }


    public List<Turma> listarTurma() throws SQLException {
        return turmaRepository.buscarTurmas();
    }


    public Turma atualizarTurma(Turma turma, int id) throws SQLException {
        Turma existente = turmaRepository.buscarTurmaPorId(id);
        if (existente == null) {
            throw new SQLException("Turma não encontrada para ID: " + id);
        }
        turma.setId(id);
        return turmaRepository.atualizarTurma(turma);
    }


    public Turma buscarTurmaPorId(int id) throws SQLException {
        return turmaRepository.buscarTurmaPorId(id);
    }


    public void deletarTurmaPorId(int id) throws SQLException {
        turmaRepository.deletarTurmaPorId(id);
    }
}