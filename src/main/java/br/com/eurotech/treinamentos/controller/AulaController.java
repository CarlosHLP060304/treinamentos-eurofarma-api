package br.com.eurotech.treinamentos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.eurotech.treinamentos.dto.aluno_aula.DadosAlteracaoAlunoAula;
import br.com.eurotech.treinamentos.dto.aluno_aula.DadosCadastroAlunoAula;
import br.com.eurotech.treinamentos.dto.apostila.DadosAlteracaoApostila;
import br.com.eurotech.treinamentos.dto.aula.DadosAlteracaoAula;
import br.com.eurotech.treinamentos.dto.aula.DadosCadastroAula;
import br.com.eurotech.treinamentos.dto.aula.DadosDetalhamentoAula;
import br.com.eurotech.treinamentos.dto.aula.DadosIdAula;
import br.com.eurotech.treinamentos.dto.usuario.DadosCadastroUsuario;
import br.com.eurotech.treinamentos.dto.usuario.DadosIdUsuario;
import br.com.eurotech.treinamentos.model.AlunoAula;
import br.com.eurotech.treinamentos.model.Aula;
import br.com.eurotech.treinamentos.model.Usuario;
import br.com.eurotech.treinamentos.repository.AlunoAulaRepository;
import br.com.eurotech.treinamentos.repository.AulaRepository;
import br.com.eurotech.treinamentos.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/aula")
public class AulaController {
    

    @Autowired
    private AulaRepository repository;

    @Autowired
    private AlunoAulaRepository alunoAulaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;;

    @GetMapping("/treinamento/{id}")
    public ResponseEntity<List<DadosDetalhamentoAula>> listarAulas(@PathVariable("id") Long id_treinamento){
        List<Aula> aulas = repository.findByTreinamentoIdAndAtivoTrue(id_treinamento);
        return ResponseEntity.ok(aulas.stream().map(DadosDetalhamentoAula::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoAula> mostrarAula(@PathVariable("id") Long id){
        Aula aula = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAula(aula));
    }


    @PostMapping
    @Transactional
    public List<ResponseEntity> insert(@RequestBody @Valid DadosCadastroAlunoAula dados,UriComponentsBuilder uriBuilder){
        List uris = new ArrayList<ResponseEntity>();
        for (DadosCadastroAula aula_dto : dados.aulas()) {
            Aula aula = new Aula(aula_dto);
            System.out.println(aula);
            repository.save(aula);
            //var uri = uriBuilder.path("/aula/{id}").buildAndExpand(aula.getId()).toUri();
            uris.add(new DadosDetalhamentoAula(aula));
            for(DadosIdUsuario usuario_dto : dados.alunos()){
                alunoAulaRepository.save(new AlunoAula(usuarioRepository.getReferenceById(usuario_dto.id()),aula));
            }
        }
        return uris;
    }

    @PutMapping("/users/edit")
    @Transactional
    public ResponseEntity alterarAlunoAula(@RequestBody @Valid DadosAlteracaoAlunoAula dados,UriComponentsBuilder uriBuilder){
        List<Usuario> usuarios_banco = alunoAulaRepository.findByIdAluno();
        
        for (DadosIdUsuario dadosIdUsuario : dados.alunos_deletados()) {
            alunoAulaRepository.deleteByUsuarioId(dadosIdUsuario.id());
        }

        for(DadosIdUsuario dadosIdUsuario : dados.alunos()){
            for (Usuario usuario_banco : usuarios_banco) {
                if(!usuario_banco.getId().equals(dadosIdUsuario.id())){
                    for(DadosIdAula dadosIdAula : dados.aulas()){
                        alunoAulaRepository.save(new AlunoAula(usuarioRepository.getReferenceById(dadosIdUsuario.id()),repository.getReferenceById(dadosIdAula.id())));
                    }
                }
            }
            
        }
         
        return ResponseEntity.noContent().build();
    }
      
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity alterarAula(@PathVariable("id") Long id,@RequestBody @Valid DadosAlteracaoAula dados){
        Aula aula = repository.getReferenceById(id);
        aula.setAula(dados);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirAula(@PathVariable("id") Long id){
        Aula aula = repository.getReferenceById(id);
        aula.setAtivo(false);
        return ResponseEntity.noContent().build();
    }
   

}
