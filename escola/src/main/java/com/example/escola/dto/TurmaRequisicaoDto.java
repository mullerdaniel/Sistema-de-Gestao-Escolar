package com.example.escola.dto;

import jakarta.validation.constraints.NotNull;

public record TurmaRequisicaoDto (
        @NotNull(message = "O nome da turma é obrigatorio!")
        String nome,
        @NotNull(message = "O Id do curso é obrigatorio!")
        int curso_id,
        @NotNull(message = "O Id do professor é obrigatorio")
        int professor_id
){
}
