package com.example.escola.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AulaRequisicaoDto (
        @NotNull(message = "O Id da turma é obrigatorio!")
        int turma_id,
        @NotNull(message = "A data da aula é obrigatoria!")
        LocalDate data_hora,
        @NotBlank(message = "O assunto da aula é obrigatorio!")
        @Size(max = 300, message = "O assunto da aula deve ter no maximo 300 caracteres!")
        String assunto
){
}
