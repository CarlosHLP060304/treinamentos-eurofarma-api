package br.com.eurotech.treinamentos.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.eurotech.treinamentos.dto.usuario.DadosDetalhamentoUsuario;
import br.com.eurotech.treinamentos.model.Setor;
import br.com.eurotech.treinamentos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

    UserDetails findByCpf(String subject);


    @Query(value = "SELECT * FROM tb_usuario WHERE id IN (SELECT id_aluno FROM tb_aluno_aula WHERE id_aula = (SELECT id FROM tb_aula WHERE id_treinamento = :id_treinamento AND ativo=1 LIMIT 1) )  AND  ativo = 1 ",nativeQuery = true)
    List<Usuario> findByTreinamento(@Param("id_treinamento")  Long idTreinamento);
 

    List<Usuario> findBySetor(Setor setor);

    Usuario findByRe(String re);

    @Query(value = "select * from tb_usuario where nome like concat('%', :query, '%') or cpf like concat('%', :query, '%') or re like concat('%', :query, '%') or setor like concat('%', :query, '%')", nativeQuery = true)
    List<Usuario> findByQuery(@Param("query") String query);

    @Query(value = "select * from tb_usuario where nome like('%', :query, '%') or cpf  like('%', :query, '%') or re like('%', :query, '%')",nativeQuery = true)
    List<Usuario> findByNomeOrCpfOrRe(@Param("query") String query);
}
    
    
