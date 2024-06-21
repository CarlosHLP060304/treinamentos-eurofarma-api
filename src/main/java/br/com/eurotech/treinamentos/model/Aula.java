package br.com.eurotech.treinamentos.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import javax.print.DocFlavor.STRING;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="tb_aula")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Aula {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sala;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    @ManyToOne
    @JoinColumn(name = "id_treinamento",nullable = false)
    private Treinamento treinamento;


    private Boolean ativo;

    @OneToMany(mappedBy = "aula")
    private List<AlunoAula> alunoAula;
    

    public Long getTempoAula(){
        return Duration.between(dataInicio, dataFim).toMinutes();
    }
    
}
