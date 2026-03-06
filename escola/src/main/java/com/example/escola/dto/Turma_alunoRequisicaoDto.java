package com.example.escola.dto;

import com.example.escola.model.Turma;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record Turma_alunoRequisicaoDto (
        @NotNull(message = "O Id da turma é obrigatorio!")
        int turma_id,
        @NotNull(message = "O Id do aluno é obrigatorio!")
        int aluno_id,
        List<Turma> listaAlunoIds
){
}
