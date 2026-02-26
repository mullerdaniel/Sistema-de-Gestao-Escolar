package com.example.escola.dto;

import java.time.LocalDate;

public record AlunoRequisicaoDto (
        String nome,
        String email,
        String matricula,
        LocalDate data_nascimento
){
}
