package com.example.escola.dto;

import com.example.escola.model.Turma;

import java.util.List;

public record Turma_alunoRequisicaoDto (
        int turma_id,
        int aluno_id,
        List<Turma> listaAlunoIds
){
}
