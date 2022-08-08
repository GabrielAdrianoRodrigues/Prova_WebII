package com.gabriel.provaDeSuficiencia.models.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.provaDeSuficiencia.models.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
