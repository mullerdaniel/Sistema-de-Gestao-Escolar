package com.example.escola.mapper;

import com.example.escola.dto.AlunoRequisicaoDto;
import com.example.escola.dto.AlunoRespostaDto;
import com.example.escola.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {
    public Aluno paraEntidade(
            AlunoRequisicaoDto alunoRequisicaoDto){
        return new Aluno(
                alunoRequisicaoDto.nome(),
                alunoRequisicaoDto.email(),
                alunoRequisicaoDto.matricula()
        );
    }
    public AlunoRespostaDto paraRespostaDto(
            Aluno aluno
    ){
        return new AlunoRespostaDto(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getMatricula()
        );
    }
}
