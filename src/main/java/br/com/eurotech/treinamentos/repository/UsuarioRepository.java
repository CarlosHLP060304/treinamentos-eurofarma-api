package br.com.eurotech.treinamentos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.eurotech.treinamentos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

    UserDetails findByCpf(String subject);
    
    @Query("SELECT a FROM Apostila a WHERE a.treinamento.id = : cpf")
    List<Usuario> findAllByCpf(String cpf);
    
}
