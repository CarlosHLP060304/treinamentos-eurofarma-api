package br.com.eurotech.treinamentos.model;

import java.util.List;

import br.com.eurotech.treinamentos.dto.usuario.DadosAlteracaoUsuario;
import br.com.eurotech.treinamentos.dto.usuario.DadosCadastroUsuario;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_usuario")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String cpf;
    
    private String nome;
    
    private String senha;
    
    private Boolean ativo = true;
    
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    @OneToMany(mappedBy = "aluno")
    private List<AlunoAula> alunoAula;
    
    public Usuario(DadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.senha = dados.senha();
        this.tipo = dados.tipo();    
    }


    public void setUsuario(DadosAlteracaoUsuario dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.senha = dados.senha();
        this.tipo = dados.tipo();    
    }

    

}