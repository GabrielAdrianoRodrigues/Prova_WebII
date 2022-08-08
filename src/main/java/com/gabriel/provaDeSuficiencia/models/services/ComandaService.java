package com.gabriel.provaDeSuficiencia.models.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.provaDeSuficiencia.models.DTO.ProdutoDTO;
import com.gabriel.provaDeSuficiencia.models.DTO.UsuarioDTO;
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

    public List<UsuarioDTO> findAll() {
        List<Usuario> comandas = usuarioRepository.findAll(); 
        List<UsuarioDTO> response = comandas.stream().map(x -> new UsuarioDTO(x.getIdUsuario(), x.getNomeUsuario(), x.getTelefoneUsuario())).collect(Collectors.toList());

        return response;
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        usuario.getProdutos().stream().forEach(x-> x.setUsuario(usuario));
        return usuarioRepository.save(usuario);
    }

    public JSONObject delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
        return new JSONObject().put("succes", new JSONObject().put("text", "comanda removida!"));
    }

    public Optional<Produto> findProductById(Long id) {
        return produtoRepository.findById(id);
    }

    public List<Produto> updateProduct(ProdutoDTO produtosDTO, Usuario usuario) {
        List<Produto> produtos = produtosDTO.getProdutos();
        for (Produto produtoUsuario : usuario.getProdutos() ) {
            for (Produto produtoDTO : produtos) {
                if (produtoUsuario.getId() == produtoDTO.getId()) {
                    //usuarioRepository.updateProduto(produtoUsuario.getId(), produtoDTO.getNome(), produtoDTO.getPreco());
                    produtoUsuario.setNome(produtoDTO.getNome());
                    produtoUsuario.setPreco(produtoDTO.getPreco());
                } 
            }
        }
        usuarioRepository.save(usuario);
        return usuario.getProdutos();
    }
}
