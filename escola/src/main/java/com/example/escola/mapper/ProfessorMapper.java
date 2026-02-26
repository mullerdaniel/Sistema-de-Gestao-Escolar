package com.example.escola.mapper;

import com.example.escola.dto.ProfessorRequisicaoDto;
import com.example.escola.dto.ProfessorRespostaDto;
import com.example.escola.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {
    public Professor paraEntidade(
            ProfessorRequisicaoDto professorRequisicaoDto){
        return new Professor(
                professorRequisicaoDto.nome(),
                professorRequisicaoDto.email(),
                professorRequisicaoDto.disciplina()
        );
    }
    public ProfessorRespostaDto professorRespostaDto(
            Professor professor
    ){
        return new ProfessorRespostaDto(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getDisciplina()
        );
    }
}
