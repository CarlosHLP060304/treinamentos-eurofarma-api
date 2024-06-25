package br.com.eurotech.treinamentos.dto.aula;

import java.time.LocalDateTime;

import br.com.eurotech.treinamentos.model.Aula;



public record DadosDetalhamentoAula(
    Long id,
     
    String sala,

    LocalDateTime dataInicio,

    LocalDateTime dataFim,

    Boolean ativo

){
    public DadosDetalhamentoAula(Aula aula){
        this(aula.getId(),aula.getSala(), aula.getDataInicio(),aula.getDataFim(), aula.getAtivo());
    }
}
