package br.com.eurotech.treinamentos.dto.apostila;

import br.com.eurotech.treinamentos.model.Apostila;
import br.com.eurotech.treinamentos.model.Treinamento;

public record DadosDetalhamentoApostila(
    
    String link,

    Treinamento treinamento

) {
    public DadosDetalhamentoApostila(Apostila apostila){
        this(apostila.getLink(), apostila.getTreinamento());
    }
}