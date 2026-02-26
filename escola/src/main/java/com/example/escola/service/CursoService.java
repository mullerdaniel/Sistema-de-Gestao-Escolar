package com.example.escola.service;

import com.example.escola.model.Curso;
import com.example.escola.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }


    public Curso salvarCurso(Curso curso) throws SQLException {
        return cursoRepository.salvarCurso(curso);
    }


    public List<Curso> listarCurso() throws SQLException {
        return cursoRepository.buscarCursos();
    }


    public Curso atualizarCurso(Curso curso, int id) throws SQLException {
        Curso existente = cursoRepository.buscarCursoPorId(id);
        if (existente == null) {
            throw new SQLException("Curso não encontrado para ID: " + id);
        }
        curso.setId(id);
        return cursoRepository.atualizarCurso(curso);
    }


    public Curso buscarCursoPorId(int id) throws SQLException {
        return cursoRepository.buscarCursoPorId(id);
    }


    public void deletarCursoPorId(int id) throws SQLException {
        cursoRepository.deletarCursoPorId(id);
    }
}