package br.com.eurotech.treinamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eurotech.treinamentos.dto.questionario.DadosCadastroQuestionario;
import br.com.eurotech.treinamentos.model.Questionario;
import br.com.eurotech.treinamentos.services.QuestionarioService;

@RestController
@RequestMapping("/questionario")
public class QuestionarioController {
    
    @Autowired
    QuestionarioService service;

    @PostMapping
    public ResponseEntity<DadosCadastroQuestionario> insertQuestionario(@RequestBody DadosCadastroQuestionario dto){
        System.out.println(dto);
        service.criarQuestionario(new Questionario());    
        return ResponseEntity.ok(dto);
    }

}
