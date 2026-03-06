package com.example.escola.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoRequisicaoDto (
        @NotNull(message = "O Nome do aluno é obrigatorio!")
        @Size(min = 3, max = 100, message = "O nome deve ter de 3 á 100 caracteres!")
        String nome,
        @NotNull(message = "O Email do aluno é obrigatorio!")
        @Email(message = "Email Invalido!")
        String email,
        @NotNull(message = "A Matricula do aluno é obrigatorio!")
        String matricula,
        @NotNull(message = "A Data de Nascimento do aluno é obrigatorio!")
        @Past(message = "A Data de Nascimento deve ser no passado!")
        LocalDate data_nascimento
){
}
