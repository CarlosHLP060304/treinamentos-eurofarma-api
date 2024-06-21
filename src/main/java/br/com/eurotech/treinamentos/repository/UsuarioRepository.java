package br.com.eurotech.treinamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eurotech.treinamentos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
}
