package com.example.escola.service;

import com.example.escola.model.Aula;
import com.example.escola.repository.AulaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AulaService {

    private final AulaRepository aulaRepository;

    public AulaService(AulaRepository aulaRepository) {
        this.aulaRepository = aulaRepository;
    }


    public Aula salvarAula(Aula aula) throws SQLException {
        return aulaRepository.salvarAula(aula);
    }


    public List<Aula> listarAula() throws SQLException {
        return aulaRepository.buscarTodos();
    }


    public Aula atualizarAula(Aula aula, int id) throws SQLException {
        Aula existente = aulaRepository.buscarPorId(id);
        if (existente == null) {
            throw new SQLException("Aula não encontrada para ID: " + id);
        }
        aula.setId(id);
        return aulaRepository.atualizar(aula);
    }


    public Aula buscarAulaPorId(int id) throws SQLException {
        return aulaRepository.buscarPorId(id);
    }


    public void deletarAulaPorId(int id) throws SQLException {
        aulaRepository.deletarPorId(id);
    }
}