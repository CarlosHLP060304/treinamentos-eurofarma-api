package br.com.eurotech.treinamentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eurotech.treinamentos.model.Aula;

public interface AulaRepository extends JpaRepository<Aula,Long>{

    List<Aula> findByTreinamentoId(Long id_treinamento);
    
}
