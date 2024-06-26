package br.com.eurotech.treinamentos.dto.treinamento;

import java.time.LocalDate;
import java.util.Set;

import br.com.eurotech.treinamentos.model.Apostila;
import br.com.eurotech.treinamentos.model.Aula;
import br.com.eurotech.treinamentos.model.Formato;
import br.com.eurotech.treinamentos.model.Treinamento;

public record DadosDetalhamentoTreinamento(
     Long id,
     
     String nome,
     
     String descricao,

     Formato formato,

     Boolean ativo,
    
     LocalDate dataInicio,
       
     LocalDate dataFim,

     String capa,

     String nomeProfessor,

     String cpfProfessor
){

     public DadosDetalhamentoTreinamento(Treinamento treinamento) {
          this(treinamento.getId(), treinamento.getNome(), treinamento.getDescricao(), treinamento.getFormato(), treinamento.getAtivo(), treinamento.getDataInicio(), treinamento.getDataFim(), treinamento.getCapa(), treinamento.getNomeProfessor(), treinamento.getCpfProfessor());
     }

    
}