package br.com.eurotech.treinamentos.dto.apostila;

import br.com.eurotech.treinamentos.model.Treinamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAlteracaoApostila(
    
    @NotBlank(message = "O campo de link não pode estar vazio")
    String link


) {

}