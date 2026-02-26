package com.example.escola.repository;

import com.example.escola.model.Curso;
import com.example.escola.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class CursoRepository {


    // SALVAR
    public Curso salvarCurso(Curso curso) throws SQLException {
        String query = "INSERT INTO curso (nome, codigo) VALUES (?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCodigo());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                curso.setId(rs.getInt(1));
                return curso;
            }
        }
        return curso;
    }
}
