package com.example.escola.repository;

import com.example.escola.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Turma_alunoRepository {


    // SALVAR
    public void salvarTurma_aluno(int turma_id, int aluno_id) throws SQLException {
        String query = "INSERT INTO turma_aluno (turma_id, aluno_id) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, turma_id);
            stmt.setInt(2, aluno_id);
            stmt.executeUpdate();
        }
    }


    // REMOVER
    public void remover(int turma_id, int aluno_id) throws SQLException {
        String query = "DELETE FROM turma_aluno WHERE turma_id = ? AND aluno_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, turma_id);
            stmt.setInt(2, aluno_id);
            stmt.executeUpdate();
        }
    }


    // BUSCAR ALUNOS POR TURMA
    public List<Integer> buscarAlunosPorTurma(int turma_id) throws SQLException {
        List<Integer> alunos = new ArrayList<>();
        String query = "SELECT aluno_id FROM turma_aluno WHERE turma_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, turma_id);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    alunos.add(rs.getInt("aluno_id"));
                }
            }
        }

        return alunos;
    }


    // BUSCAR TURMAS POR ALUNO
    public List<Integer> buscarTurmasPorAluno(int aluno_id) throws SQLException {
        List<Integer> turmas = new ArrayList<>();
        String query = "SELECT turma_id FROM turma_aluno WHERE aluno_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, aluno_id);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    turmas.add(rs.getInt("turma_id"));
                }
            }
        }

        return turmas;
    }


    // REMOVER TODOS ALUNOS DE UMA TURMA
    public void removerTodosAlunosDaTurma(int turma_id) throws SQLException {
        String query = "DELETE FROM turma_aluno WHERE turma_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, turma_id);
            stmt.executeUpdate();
        }
    }


    // REMOVER ALUNO DE TODAS TURMAS
    public void removerAlunoDeTodasTurmas(int aluno_id) throws SQLException {
        String query = "DELETE FROM turma_aluno WHERE aluno_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, aluno_id);
            stmt.executeUpdate();
        }
    }
}