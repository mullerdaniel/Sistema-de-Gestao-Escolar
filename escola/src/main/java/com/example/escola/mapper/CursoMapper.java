package com.example.escola.mapper;

import com.example.escola.dto.CursoRequisicaoDto;
import com.example.escola.dto.CursoRespostaDto;
import com.example.escola.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {
    public Curso paraEntidade(
            CursoRequisicaoDto cursoRequisicaoDto){
        return new Curso(
                cursoRequisicaoDto.nome(),
                cursoRequisicaoDto.codigo()
        );
    }
    public CursoRespostaDto cursoRespostaDto(
            Curso curso
    ){
        return new CursoRespostaDto(
                curso.getId(),
                curso.getNome(),
                curso.getCodigo()
        );
    }
}
