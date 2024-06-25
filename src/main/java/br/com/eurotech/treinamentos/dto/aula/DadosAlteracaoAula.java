package br.com.eurotech.treinamentos.dto.aula;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.eurotech.treinamentos.model.Treinamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAlteracaoAula(
    @NotBlank(message = "Campo de sala não pode estar vazio")
    String sala,

    @NotNull(message = "Campo de data de início não pode estar vazio")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    LocalDateTime dataInicio,

    @NotNull(message = "Campo de data de fim não pode estar vazio")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    LocalDateTime dataFim

) {
    
}
