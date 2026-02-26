package com.example.escola.repository;

import com.example.escola.model.Aluno;
import com.example.escola.model.Turma;
import com.example.escola.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TurmaRepository {


    // SALVAR
    public Turma salvarTurma(Turma turma) throws SQLException {
        String query = "INSERT INTO turma (nome, curso_id, professor_id) VALUES (?,?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, turma.getNome());
            stmt.setInt(2, turma.getCurso_id());
            stmt.setInt(3, turma.getProfessor_id());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                turma.setId(rs.getInt(1));
            }
        }

        return turma;
    }


    // BUSCAR TODOS
    public List<Turma> buscarTurmas() throws SQLException {
        List<Turma> listaTurmas = new ArrayList<>();

        String query = """
                SELECT id,
                nome,
                curso_id,
                professor_id
                FROM turma
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                listaTurmas.add(new Turma(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("curso_id"),
                        rs.getInt("professor_id")
                ));
            }
        }

        return listaTurmas;
    }


    // BUSCAR POR ID
    public Turma buscarTurmaPorId(int id) throws SQLException {
        String query = """
                SELECT id,
                nome,
                curso_id,
                professor_id
                FROM turma
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Turma(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getInt("curso_id"),
                            rs.getInt("professor_id")
                    );
                }
            }
        }

        return null;
    }


    // ATUALIZAR
    public Turma atualizarTurma(Turma turma) throws SQLException {
        String query = """
                UPDATE turma
                SET nome = ?,
                curso_id = ?,
                professor_id = ?
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, turma.getNome());
            stmt.setInt(2, turma.getCurso_id());
            stmt.setInt(3, turma.getProfessor_id());
            stmt.setInt(4, turma.getId());

            stmt.executeUpdate();
        }

        return turma;
    }


    // DELETAR POR ID
    public void deletarTurmaPorId(int id) throws SQLException {
        String query = "DELETE FROM turma WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


    public List<Aluno> buscarAlunosPorTurmaId(Long turmaId) throws SQLException {
        List<Aluno> alunos = new ArrayList<>();

        String sql = """
        SELECT a.id, a.nome, a.email, a.matricula, a.data_nascimento
        FROM aluno a
        JOIN turma_aluno ta ON a.id = ta.aluno_id
        WHERE ta.turma_id = ?
    """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, turmaId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    alunos.add(new Aluno(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("matricula"),
                            rs.getDate("data_nascimento").toLocalDate()
                    ));
                }
            }
        }
        return alunos;
    }
}