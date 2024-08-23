package br.com.eurotech.treinamentos.dto.questao;

import java.util.List;

import com.google.cloud.firestore.QueryDocumentSnapshot;

public record DadosDetalhamentoQuestao(
    String resposta,
    List<String> alternativas,
    String pergunta
) {
    public DadosDetalhamentoQuestao(QueryDocumentSnapshot doc){
        this(doc.getString("resposta"), doc.get("alternativas",List.class), doc.getString("pergunta"));
    } 
}