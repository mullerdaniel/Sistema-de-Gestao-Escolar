package com.example.escola.repository;

import com.example.escola.model.Nota;
import com.example.escola.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NotaRepository {


    // SALVAR
    public Nota salvarNota(Nota nota) throws SQLException {
        String query = "INSERT INTO nota (aluno_id, aula_id, valor) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, nota.getAluno_id());
            stmt.setInt(2, nota.getAula_id());
            stmt.setDouble(3, nota.getValor());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                nota.setId(rs.getInt(1));
            }
        }

        return nota;
    }


    // BUSCAR TODOS
    public List<Nota> buscarTodos() throws SQLException {
        List<Nota> notas = new ArrayList<>();
        String query = "SELECT id, aluno_id, aula_id, valor FROM nota";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                notas.add(new Nota(
                        rs.getInt("id"),
                        rs.getInt("aluno_id"),
                        rs.getInt("aula_id"),
                        rs.getDouble("valor")
                ));
            }
        }

        return notas;
    }


    // BUSCAR POR ID
    public Nota buscarPorId(int id) throws SQLException {
        String query = "SELECT id, aluno_id, aula_id, valor FROM nota WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Nota(
                            rs.getInt("id"),
                            rs.getInt("aluno_id"),
                            rs.getInt("aula_id"),
                            rs.getDouble("valor")
                    );
                }
            }
        }

        return null;
    }


    // ATUALIZAR
    public Nota atualizar(Nota nota) throws SQLException {
        String query = "UPDATE nota SET aluno_id = ?, aula_id = ?, valor = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, nota.getAluno_id());
            stmt.setInt(2, nota.getAula_id());
            stmt.setDouble(3, nota.getValor());
            stmt.setInt(4, nota.getId());

            stmt.executeUpdate();
        }

        return nota;
    }


    // DELETAR POR ID
    public void deletarPorId(int id) throws SQLException {
        String query = "DELETE FROM nota WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


    // BUSCAR NOTAS POR ALUNO
    public List<Nota> buscarPorAluno(int aluno_id) throws SQLException {
        List<Nota> notas = new ArrayList<>();
        String query = "SELECT id, aluno_id, aula_id, valor FROM nota WHERE aluno_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, aluno_id);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    notas.add(new Nota(
                            rs.getInt("id"),
                            rs.getInt("aluno_id"),
                            rs.getInt("aula_id"),
                            rs.getDouble("valor")
                    ));
                }
            }
        }

        return notas;
    }


    // BUSCAR NOTAS POR AULA
    public List<Nota> buscarPorAula(int aula_id) throws SQLException {
        List<Nota> notas = new ArrayList<>();
        String query = "SELECT id, aluno_id, aula_id, valor FROM nota WHERE aula_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, aula_id);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    notas.add(new Nota(
                            rs.getInt("id"),
                            rs.getInt("aluno_id"),
                            rs.getInt("aula_id"),
                            rs.getDouble("valor")
                    ));
                }
            }
        }

        return notas;
    }


    // REMOVER NOTAS DE UM ALUNO
    public void removerPorAluno(int aluno_id) throws SQLException {
        String query = "DELETE FROM nota WHERE aluno_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, aluno_id);
            stmt.executeUpdate();
        }
    }


    // REMOVER NOTAS DE UMA AULA
    public void removerPorAula(int aula_id) throws SQLException {
        String query = "DELETE FROM nota WHERE aula_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, aula_id);
            stmt.executeUpdate();
        }
    }

}