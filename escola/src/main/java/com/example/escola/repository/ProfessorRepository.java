package com.example.escola.repository;

import com.example.escola.model.Professor;
import com.example.escola.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfessorRepository {


    // SALVAR
    public Professor salvarProfessor(Professor professor) throws SQLException {
        String query = "INSERT INTO professor(nome, email, disciplina) VALUES (?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDisciplina());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                professor.setId(rs.getInt(1));
                return professor;
            }
        }
        return professor;
    }


    // BUSCARTODOS
    public List<Professor> buscarProfessor() throws SQLException {
        List<Professor> listarProfessores = new ArrayList<>();
        String query = """
                SELECT id,
                nome,
                email,
                disciplina
                FROM professor
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                listarProfessores.add(new Professor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("disciplina")
                ));
            }
        }
        return listarProfessores;
    }


    // BUSCAR POR ID
    public Professor buscarPofessorPorId(int id) throws SQLException {
        String query = """
                SELECT id,
                nome,
                email,
                disciplina
                FROM professor
                WHERE id = ?
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    return new Professor(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("disciplina")
                    );
                }
            }
        }
        return null;
    }
}
