package com.example.escola.dto;

import java.time.LocalDate;

public record AlunoRespostaDto (
        int id,
        String nome,
        String email,
        String matricula,
        LocalDate data_nascimento
) {
}
