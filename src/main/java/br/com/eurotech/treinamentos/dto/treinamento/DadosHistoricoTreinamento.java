package br.com.eurotech.treinamentos.dto.treinamento;

import java.time.LocalDateTime;

public record DadosHistoricoTreinamento(
    Long id_aluno,
    Boolean aula_concluida,
    String nome,
    LocalDateTime data_inicio
) {
    public DadosHistoricoTreinamento(Long id_aluno, Boolean aula_concluida, String nome, LocalDateTime data_inicio) {
        this.id_aluno = id_aluno;
        this.aula_concluida = aula_concluida;
        this.nome = nome;
        this.data_inicio = data_inicio;
    }

}