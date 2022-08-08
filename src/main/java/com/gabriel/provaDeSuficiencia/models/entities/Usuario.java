package com.gabriel.provaDeSuficiencia.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "idUsuario", nullable = false)
    private Long idUsuario;

    @Column(name = "nomeUsuario", nullable = false)
    private String nomeUsuario;

    @Column(name = "telefoneUsuario", nullable = false)
    private String telefoneUsuario;
    
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Produto> produtos = new ArrayList<Produto>();

    public Long getId() {
        return id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void addComment(Produto produto) {
        produtos.add(produto);
    }
    
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario + ", produtos="
                + produtos + ", telefoneUsuario=" + telefoneUsuario + "]";
    }

}
