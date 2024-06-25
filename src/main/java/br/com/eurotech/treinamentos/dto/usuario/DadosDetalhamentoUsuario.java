package br.com.eurotech.treinamentos.dto.usuario;

import br.com.eurotech.treinamentos.model.TipoUsuario;
import br.com.eurotech.treinamentos.model.Usuario;

public record DadosDetalhamentoUsuario(
    Long id,
    String cpf,
    String nome,
    String senha,
    Boolean ativo,
    TipoUsuario tipo
) {
    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getId(),usuario.getCpf(), usuario.getNome(), usuario.getSenha(), usuario.getAtivo(), usuario.getTipo());
    }
}
