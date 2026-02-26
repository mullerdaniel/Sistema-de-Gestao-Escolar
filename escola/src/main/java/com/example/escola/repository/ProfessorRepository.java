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



}
