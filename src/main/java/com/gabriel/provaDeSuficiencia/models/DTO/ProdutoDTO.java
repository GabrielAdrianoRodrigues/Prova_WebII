package com.gabriel.provaDeSuficiencia.models.DTO;

import java.util.List;

import com.gabriel.provaDeSuficiencia.models.entities.Produto;

public class ProdutoDTO {

    List<Produto> produtos;

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
