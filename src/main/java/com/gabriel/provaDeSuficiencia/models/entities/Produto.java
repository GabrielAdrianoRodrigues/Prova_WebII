package com.gabriel.provaDeSuficiencia.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "preco", nullable = false)
    private Long preco;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_usuario_id")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPreco() {
        return this.preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
    }
}
