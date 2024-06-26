package br.com.eurotech.treinamentos.dto.treinamento;

import java.time.LocalDate;
import java.util.Set;

import br.com.eurotech.treinamentos.dto.apostila.DadosCadastroApostila;
import br.com.eurotech.treinamentos.dto.aula.DadosDetalhamentoAula;
import br.com.eurotech.treinamentos.model.Apostila;
import br.com.eurotech.treinamentos.model.Aula;
import br.com.eurotech.treinamentos.model.Formato;
import br.com.eurotech.treinamentos.model.Treinamento;

public record DadosListagemTreinamento(
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
      
     // Set<DadosDetalhamentoAula> aulas,

     // Set<DadosDelhamentoApostila> apostilas
){

     public DadosListagemTreinamento(Treinamento treinamento) {
          this(treinamento.getId(), treinamento.getNome(), treinamento.getDescricao(), treinamento.getFormato(), treinamento.getAtivo(), treinamento.getDataInicio(), treinamento.getDataFim(), treinamento.getCapa(), treinamento.getNomeProfessor(), treinamento.getCpfProfessor());
     }

    
}