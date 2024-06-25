package br.com.eurotech.treinamentos.controller;

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

import br.com.eurotech.treinamentos.dto.apostila.DadosAlteracaoApostila;
import br.com.eurotech.treinamentos.dto.aula.DadosAlteracaoAula;
import br.com.eurotech.treinamentos.dto.aula.DadosCadastroAula;
import br.com.eurotech.treinamentos.dto.aula.DadosDetalhamentoAula;
import br.com.eurotech.treinamentos.model.Aula;
import br.com.eurotech.treinamentos.repository.AulaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/aula")
public class AulaController {
    

    @Autowired
    private AulaRepository repository;

    @GetMapping("/treinamento/{id}")
    public ResponseEntity<List<DadosDetalhamentoAula>> listarAulas(@PathVariable("id") Long id_treinamento){
        List<Aula> aulas = repository.findByTreinamentoId(id_treinamento);
        return ResponseEntity.ok(aulas.stream().map(DadosDetalhamentoAula::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoAula> mostrarAula(@PathVariable("id") Long id){
        Aula aula = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAula(aula));
    }


    @PostMapping
    @Transactional
    public ResponseEntity insert(@RequestBody @Valid DadosCadastroAula dados,UriComponentsBuilder uriBuilder){
        Aula aula = new Aula(dados);
        System.out.println(dados);
        repository.save(aula);
        var uri = uriBuilder.path("/aula/{id}").buildAndExpand(aula.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAula(aula));
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
