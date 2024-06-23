package br.com.eurotech.treinamentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eurotech.treinamentos.model.Apostila;

public interface ApostilaRepository extends JpaRepository<Apostila,Long>{

    @Query("SELECT a FROM Apostila a WHERE a.treinamento.id = :treinamentoId")
    List<Apostila> findApostilasByTreinamentoId(Long treinamentoId);
    
}