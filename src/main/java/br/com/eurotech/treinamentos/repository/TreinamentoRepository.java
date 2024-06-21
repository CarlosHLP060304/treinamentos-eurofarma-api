package br.com.eurotech.treinamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eurotech.treinamentos.model.Treinamento;

public interface TreinamentoRepository extends JpaRepository<Treinamento,Long>{
    
}
