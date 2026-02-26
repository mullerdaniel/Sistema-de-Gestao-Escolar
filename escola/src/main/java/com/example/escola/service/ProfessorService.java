package com.example.escola.service;

import com.example.escola.model.Professor;
import com.example.escola.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }


    public Professor salvarProfessor(Professor professor) throws SQLException {
        return professorRepository.salvarProfessor(professor);
    }


    public List<Professor> listarProfessor() throws SQLException {
        return professorRepository.buscarProfessor();
    }


    public Professor atualizarProfessor(Professor professor, int id) throws SQLException {
        Professor existente = professorRepository.buscarPofessorPorId(id);
        if (existente == null) {
            throw new SQLException("Professor não encontrado para ID: " + id);
        }
        professor.setId(id);
        return professorRepository.atualizarProfessor(professor);
    }


    public Professor buscarProfessorPorId(int id) throws SQLException {
        return professorRepository.buscarPofessorPorId(id);
    }


    public void deletarProfessorPorId(int id) throws SQLException {
        professorRepository.deletarProfessorPorId(id);
    }
}