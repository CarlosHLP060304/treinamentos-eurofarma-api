package br.com.eurotech.treinamentos.controller;

import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.eurotech.treinamentos.dto.usuario.DadosDetalhamentoUsuario;
import br.com.eurotech.treinamentos.model.Usuario;
import br.com.eurotech.treinamentos.repository.UsuarioRepository;
import br.com.eurotech.treinamentos.services.ExcelService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/excel/download")
public class ExcelController {
    
    @Autowired
    ExcelService service;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<InputStreamResource> downloadExcel(@RequestParam("id") Long id){
        System.out.println(id);
        
        Usuario usuario = usuarioRepository.getReferenceById(id); 
        ByteArrayInputStream bais = service.createHistoricoFuncionarioExcelFile(usuario);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename="+usuario.getNome()+ "_" + usuario.getRe() +".xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(bais));
    }
}
