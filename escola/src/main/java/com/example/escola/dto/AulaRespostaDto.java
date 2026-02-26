package com.example.escola.dto;

import java.time.LocalDate;

public record AulaRespostaDto (
    int id,
    int turma_id,
    LocalDate data_hora,
    String assunto
){
}
