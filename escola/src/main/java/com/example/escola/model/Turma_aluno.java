package com.example.escola.model;

public class Turma_aluno {

    private int id;
    private int turma_id;
    private int aluno_id;


    public Turma_aluno(int id, int turma_id, int aluno_id) {
        this.id = id;
        this.turma_id = turma_id;
        this.aluno_id = aluno_id;
    }

    public Turma_aluno(int turma_id, int aluno_id) {
        this.turma_id = turma_id;
        this.aluno_id = aluno_id;
    }

    public Turma_aluno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTurma_id() {
        return turma_id;
    }

    public void setTurma_id(int turma_id) {
        this.turma_id = turma_id;
    }

    public int getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }
}
