package com.example.escola.mapper;

import com.example.escola.dto.AulaRequisicaoDto;
import com.example.escola.dto.AulaRespostaDto;
import com.example.escola.model.Aula;

public class AulaMapper {
    public Aula paraEntidade(
            AulaRequisicaoDto aulaRequisicaoDto){
        return new Aula(
                aulaRequisicaoDto.turma_id(),
                aulaRequisicaoDto.data_hora(),
                aulaRequisicaoDto.assunto()
        );
    }
    public AulaRespostaDto aulaRespostaDto(
            Aula aula
    ){
        return new AulaRespostaDto(
                aula.getId(),
                aula.getTurma_id(),
                aula.getData_hora(),
                aula.getAssunto()
        );
    }
}
