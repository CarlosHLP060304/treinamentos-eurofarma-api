package br.com.eurotech.treinamentos.dto.aluno_aula;

import java.util.List;

import br.com.eurotech.treinamentos.dto.aula.DadosIdAula;
import br.com.eurotech.treinamentos.dto.usuario.DadosIdUsuario;

public record DadosAlteracaoAlunoAula(
    List <DadosIdAula> aulas,
    List <DadosIdUsuario> alunos,
    List <DadosIdUsuario> alunos_deletados
) {
    
}
