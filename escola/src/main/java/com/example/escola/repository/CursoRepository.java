package com.example.escola.repository;

import com.example.escola.model.Curso;
import com.example.escola.model.Turma;
import com.example.escola.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepository {


    // SALVAR
    public Curso salvarCurso(Curso curso) throws SQLException {
        String query = "INSERT INTO curso (nome, codigo) VALUES (?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCodigo());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                curso.setId(rs.getInt(1));
            }
        }
        return curso;
    }


    // BUSCAR TODOS
    public List<Curso> buscarCursos() throws SQLException {
        List<Curso> listaCursos = new ArrayList<>();

        String query = """
                SELECT id,
                nome,
                codigo
                FROM curso
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                listaCursos.add(new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("codigo")
                ));
            }
        }

        return listaCursos;
    }


    // BUSCAR POR ID
    public Curso buscarCursoPorId(int id) throws SQLException {
        String query = """
                SELECT id,
                nome,
                codigo
                FROM curso
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Curso(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("codigo")
                    );
                }
            }
        }

        return null;
    }


    // ATUALIZAR
    public Curso atualizarCurso(Curso curso) throws SQLException {
        String query = """
                UPDATE curso
                SET nome = ?,
                codigo = ?
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCodigo());
            stmt.setInt(3, curso.getId());

            stmt.executeUpdate();
        }

        return curso;
    }


    // DELETAR POR ID
    public void deletarCursoPorId(int id) throws SQLException {
        String query = "DELETE FROM curso WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


    public List<Turma> buscarTurmasPorCursoId(Long cursoId) throws SQLException {
        List<Turma> listaTurmas = new ArrayList<>();
        String query = """
        SELECT id, nome, curso_id, professor_id
        FROM turma
        WHERE curso_id = ?
        """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, cursoId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    listaTurmas.add(new Turma(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getInt("curso_id"),
                            rs.getInt("professor_id")
                    ));
                }
            }
        }
        return listaTurmas;
    }
}