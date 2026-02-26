package com.example.escola.service;

import com.example.escola.model.Nota;
import com.example.escola.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class NotaService {

    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }


    public Nota salvarNota(Nota nota) throws SQLException {
        return notaRepository.salvarNota(nota);
    }


    public List<Nota> listarNota() throws SQLException {
        return notaRepository.buscarTodos();
    }


    public Nota atualizarNota(Nota nota, int id) throws SQLException {
        Nota existente = notaRepository.buscarPorId(id);
        if (existente == null) {
            throw new SQLException("Nota não encontrada para ID: " + id);
        }
        nota.setId(id);
        return notaRepository.atualizar(nota);
    }


    public Nota buscarNotaPorId(int id) throws SQLException {
        return notaRepository.buscarPorId(id);
    }


    public void deletarNotaPorId(int id) throws SQLException {
        notaRepository.deletarPorId(id);
    }
}