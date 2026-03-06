package com.example.escola.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NotaRequisicaoDto (

        @NotNull(message = "O Id do aluno é obrigatorio!")
        int aluno_id,
        @NotNull(message = "O Id da aula é obrigatorio!")
        int aula_id,
        @NotNull(message = "Deve ter uma nota obrigatoriamente!")
        @Size(min = 0, max = 100, message = "A nota deve ser de 0 á 100")
        double valor
){
}
