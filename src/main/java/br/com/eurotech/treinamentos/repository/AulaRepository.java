package br.com.eurotech.treinamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eurotech.treinamentos.model.Aula;

public interface AulaRepository extends JpaRepository<Aula,Long>{
    
}
