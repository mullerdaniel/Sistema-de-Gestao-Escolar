package com.example.escola.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NotaRequisicaoDto (

        @NotNull(message = "O Id do aluno é obrigatorio!")
        int aluno_id,
        @NotNull(message = "O Id da aula é obrigatorio!")
        int aula_id,
        @NotNull(message = "Deve ter uma nota obrigatoriamente!")
        @Min(0)
        @Max(100)
        double valor
){
}
