package com.example.escola.mapper;

import com.example.escola.dto.NotaRequisicaoDto;
import com.example.escola.dto.NotaRespostaDto;
import com.example.escola.model.Nota;

public class NotaMapper {
    public Nota paraEntidade(
            NotaRequisicaoDto notaRequisicaoDto){
        return new Nota(
                notaRequisicaoDto.aluno_id(),
                notaRequisicaoDto.aula_id(),
                notaRequisicaoDto.valor()
        );
    }
    public NotaRespostaDto notaRespostaDto(
            Nota nota
    ){
        return new NotaRespostaDto(
                nota.getId(),
                nota.getAluno_id(),
                nota.getAula_id(),
                nota.getValor()
        );
    }
}
