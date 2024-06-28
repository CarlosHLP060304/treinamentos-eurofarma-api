package br.com.eurotech.treinamentos.model;

import java.time.LocalDate;
import java.util.Set;

import br.com.eurotech.treinamentos.dto.treinamento.DadosAlteracaoTreinamento;
import br.com.eurotech.treinamentos.dto.treinamento.DadosCadastroTreinamento;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_treinamento")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Treinamento {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Formato formato;
    
    private Boolean ativo;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private String capa;

    private String nomeProfessor;

    private String cpfProfessor;

    @OneToMany(mappedBy = "treinamento")
    private Set<Apostila> apostilas;

    @OneToMany(mappedBy = "treinamento")
    private Set<Aula> aulas;


    public Treinamento(DadosCadastroTreinamento dto) {
        this.nome = dto.nome();
        this.formato = dto.formato();
        this.ativo = dto.ativo();
        this.capa = dto.capa();
        this.nomeProfessor = dto.nomeProfessor();
        this.cpfProfessor = dto.cpfProfessor();
        this.dataInicio = dto.dataInicio();
        this.dataFim = dto.dataFim();
        this.descricao = dto.descricao();
        this.formato = dto.formato();
    }


    public void excluir() {
        this.ativo = false;
    }

    public void setTreinamento(DadosAlteracaoTreinamento dto){
        this.nome = dto.nome();
        this.formato = dto.formato();
        this.capa = dto.capa();
        this.nomeProfessor = dto.nomeProfessor();
        this.cpfProfessor = dto.cpfProfessor();
        this.dataInicio = dto.dataInicio();
        this.dataFim = dto.dataFim();
        this.descricao = dto.descricao();
        this.formato = dto.formato();
    }


    // public Boolean verificacaoDeConclusaoTreinamento(){
    //     boolean concluido = false;
    //     int contadorPresenca = 0;
    //     for (Aula aula: aulas) {
    //         if(aula.getPresente().equals(true)){
    //             contadorPresenca++;
    //         }
    //     }
    //     if (aulas.size() == contadorPresenca) {
    //         concluido = true;
    //     }
    //     return concluido;
    // }
}
