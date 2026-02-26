package com.example.escola.dto;

import com.example.escola.model.Curso;

import java.util.List;

public record CursoRespostaDto (
        int id,
        String nome,
        String codigo,
        List<Curso> listaAluno
){
}
