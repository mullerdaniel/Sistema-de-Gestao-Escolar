package com.example.escola.service;

import com.example.escola.dto.AlunoRequisicaoDto;
import com.example.escola.dto.AlunoRespostaDto;
import com.example.escola.model.Aluno;
import com.example.escola.repository.AlunoRepository;

import java.sql.SQLException;
import java.util.List;

public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }


    // SALVAR ALUNO
    public AlunoRespostaDto salvarAluno(AlunoRequisicaoDto alunoRequisicaoDto) throws SQLException {
        Aluno aluno = AlunoMap.paraEntidade(alunoRequisicaoDto);

        Aluno alunoSalvo = alunoRepository.salvarAluno(aluno);

        AlunoRespostaDto alunoRespostaDto = alunoMapper.paraRespostaDto(alunoSalvo);

        return alunoRespostaDto;
    }


    // LISTAR ALUNOS
    public List<Aluno> listarAluno() throws SQLException {
        return alunoRepository.buscarAluno();
    }


    // ATUALIZAR ALUNO
    public Aluno atualizarAluno(Aluno aluno, int id) throws SQLException {
        Aluno existente = alunoRepository.buscarAlunoPorId(id);
        if (existente == null) {
            throw new SQLException("Aluno não encontrado para ID: " + id);
        }
        aluno.setId(id);
        return alunoRepository.atualizarAluno(aluno);
    }


    // BUSCAR POR ID
    public Aluno buscarAlunoPorId(int id) throws SQLException {
        return alunoRepository.buscarAlunoPorId(id);
    }


    // DELETAR ALUNO
    public void deletarAlunoPorId(int id) throws SQLException {
        alunoRepository.deletarAlunoPorId(id);
    }
}
