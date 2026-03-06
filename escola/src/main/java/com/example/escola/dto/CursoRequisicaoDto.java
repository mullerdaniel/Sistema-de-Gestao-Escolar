package com.example.escola.dto;

import com.example.escola.model.Curso;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CursoRequisicaoDto (
        @NotNull(message = "O nome do curso é obrigatorio!")
        String nome,
        @NotNull(message = "O codigo do curso é obrigatorio!")
        String codigo,
        List<Curso> listaProfessorIds
){
}
