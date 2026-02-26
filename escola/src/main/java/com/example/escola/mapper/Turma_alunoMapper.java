package com.example.escola.mapper;

import com.example.escola.dto.Turma_alunoRequisicaoDto;
import com.example.escola.dto.Turma_alunoRespostaDto;
import com.example.escola.model.Turma_aluno;
import org.springframework.stereotype.Component;

@Component
public class Turma_alunoMapper {
    public Turma_aluno paraEntidade(
            Turma_alunoRequisicaoDto turma_alunoRequisicaoDto){
        return new Turma_aluno(
                turma_alunoRequisicaoDto.turma_id(),
                turma_alunoRequisicaoDto.aluno_id()
        );
    }
    public Turma_alunoRespostaDto turma_alunoRespostaDto(
            Turma_aluno turma_aluno
    ){
        return new Turma_alunoRespostaDto(
                turma_aluno.getTurma_id(),
                turma_aluno.getTurma_id(),
                turma_aluno.getAluno_id()
        );
    }
}
