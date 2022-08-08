package com.gabriel.provaDeSuficiencia.models.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gabriel.provaDeSuficiencia.models.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Modifying
    @Transactional
    @Query(value =
           "    UPDATE produtos                         "
          +"        SEt nome = :nomeProduto,            "
          +"            preco = :precoProduto           "
          +"    WHERE fk_usuario_id = :idUsuario        "
          +"            AND id = :id                    ",
          nativeQuery = true
    )
    void updateProduto(@Param("idUsuario") Long idUsuario,
                       @Param("id") Long idProduto,
                       @Param("nomeProduto") String nome,
                       @Param("precoProduto") Long preco
    );

}
 