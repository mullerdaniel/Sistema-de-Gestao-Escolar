package com.example.escola.model;

import java.sql.Date;
import java.time.LocalDate;

public class Aula {

    private int id;
    private int turma_id;
    private LocalDate data_hora;
    private String assunto;


    public Aula(int id, int turma_id, LocalDate data_hora, String assunto) {
        this.id = id;
        this.turma_id = turma_id;
        this.data_hora = data_hora;
        this.assunto = assunto;
    }

    public Aula(int turma_id, LocalDate data_hora, String assunto) {
        this.turma_id = turma_id;
        this.data_hora = data_hora;
        this.assunto = assunto;
    }

    public Aula() {
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

    public LocalDate getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDate data_hora) {
        this.data_hora = data_hora;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
