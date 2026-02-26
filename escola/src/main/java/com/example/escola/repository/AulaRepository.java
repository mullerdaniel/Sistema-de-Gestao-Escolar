package com.example.escola.repository;

import com.example.escola.model.Aula;
import com.example.escola.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AulaRepository {


    // SALVAR
    public Aula salvarAula(Aula aula) throws SQLException {
        String query = "INSERT INTO aula (turma_id, data_hora, assunto) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, aula.getTurma_id());
            stmt.setDate(2, Date.valueOf(aula.getData_hora()));
            stmt.setString(3, aula.getAssunto());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                aula.setId(rs.getInt(1));
            }
        }

        return aula;
    }


    // BUSCAR TODOS
    public List<Aula> buscarTodos() throws SQLException {
        List<Aula> aulas = new ArrayList<>();
        String query = "SELECT id, turma_id, data_hora, assunto FROM aula";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                aulas.add(new Aula(
                        rs.getInt("id"),
                        rs.getInt("turma_id"),
                        rs.getDate("data_hora").toLocalDate(),
                        rs.getString("assunto")
                ));
            }
        }

        return aulas;
    }


    // BUSCAR POR ID
    public Aula buscarPorId(int id) throws SQLException {
        String query = "SELECT id, turma_id, data_hora, assunto FROM aula WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Aula(
                            rs.getInt("id"),
                            rs.getInt("turma_id"),
                            rs.getDate("data_hora").toLocalDate(),
                            rs.getString("assunto")
                    );
                }
            }
        }

        return null;
    }


    // ATUALIZAR
    public Aula atualizar(Aula aula) throws SQLException {
        String query = "UPDATE aula SET turma_id = ?, data_hora = ?, assunto = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, aula.getTurma_id());
            stmt.setDate(2, Date.valueOf(aula.getData_hora()));
            stmt.setString(3, aula.getAssunto());
            stmt.setInt(4, aula.getId());

            stmt.executeUpdate();
        }

        return aula;
    }


    // DELETAR POR ID
    public void deletarPorId(int id) throws SQLException {
        String query = "DELETE FROM aula WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


    // BUSCAR AULAS POR TURMA
    public List<Aula> buscarPorTurma(int turma_id) throws SQLException {
        List<Aula> aulas = new ArrayList<>();
        String query = "SELECT id, turma_id, data_hora, assunto FROM aula WHERE turma_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, turma_id);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    aulas.add(new Aula(
                            rs.getInt("id"),
                            rs.getInt("turma_id"),
                            rs.getDate("data_hora").toLocalDate(),
                            rs.getString("assunto")
                    ));
                }
            }
        }

        return aulas;
    }
}