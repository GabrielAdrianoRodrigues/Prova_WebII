package com.gabriel.provaDeSuficiencia.models.services;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.provaDeSuficiencia.models.DTO.ProdutoDTO;
import com.gabriel.provaDeSuficiencia.models.entities.Produto;
import com.gabriel.provaDeSuficiencia.models.entities.Usuario;
import com.gabriel.provaDeSuficiencia.models.repository.ProdutoRepository;
import com.gabriel.provaDeSuficiencia.models.repository.UsuarioRepository;


@Service
public class ComandaService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Usuario> findAll() {
        List<Usuario> comandas = usuarioRepository.findAll(); 

        return comandas;
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public JSONObject delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
        return new JSONObject().put("succes", new JSONObject().put("text", "comanda removida!"));
    }

    public Optional<Produto> findProductById(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto updateProduct(ProdutoDTO produtoDTO, Produto produto) {
        produto.setNome(produtoDTO.getNome());
        produto.setPreco(produtoDTO.getPreco());
        produtoRepository.save(produto);
        return produto;
    }
}
