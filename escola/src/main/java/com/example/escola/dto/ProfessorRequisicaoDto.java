package com.example.escola.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ProfessorRequisicaoDto (
        @NotNull(message = "O nome do professor é obrigatorio!")
        String nome,
        @NotNull(message = "O email do professor é obrigatorio!")
        @Email(message = "Email invalido!")
        String email,
        @NotNull(message = "É obrigatorio ter uma disciplina!")
        String disciplina
){
}
