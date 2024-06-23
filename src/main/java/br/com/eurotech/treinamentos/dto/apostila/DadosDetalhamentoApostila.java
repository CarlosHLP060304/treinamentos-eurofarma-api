package br.com.eurotech.treinamentos.dto.apostila;

import br.com.eurotech.treinamentos.model.Apostila;

public record DadosDetalhamentoApostila(
    
    Long id,

    String link
) {
    public DadosDetalhamentoApostila(Apostila apostila){
        this(apostila.getId(),apostila.getLink());
    }
}