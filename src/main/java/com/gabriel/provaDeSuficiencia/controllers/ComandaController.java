package com.gabriel.provaDeSuficiencia.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.provaDeSuficiencia.models.DTO.ProdutoDTO;
import com.gabriel.provaDeSuficiencia.models.entities.Produto;
import com.gabriel.provaDeSuficiencia.models.entities.Usuario;
import com.gabriel.provaDeSuficiencia.models.services.ComandaService;


@RestController
@RequestMapping("/RestAPIFurb")
public class ComandaController {

    @Autowired
    ComandaService comandaService;

    @GetMapping(path = "comandas")
    public ResponseEntity<?> findAll() {
        List<Usuario> response = comandaService.findAll();
        if (response.isEmpty()) {
            return ResponseEntity.ok("A lista de comandas encontra-se vazia");
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "comandas/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {  
        Optional<Usuario> response = comandaService.findById(id);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "comandas", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postComanda(@Valid @RequestBody Usuario usuario) {  
        return ResponseEntity.ok(comandaService.save(usuario));
    }

    @PutMapping(path = "/comandas/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> putComandaById(@Valid @RequestBody ProdutoDTO produtoDTO, @PathVariable("id") Long id) {  
        Optional<Usuario> response = comandaService.findById(id);
        if (response.isPresent()) {
            Optional<Produto> userProduct = comandaService.findProductById(produtoDTO.getId());
            if (userProduct.isPresent()) {
                return ResponseEntity.ok(comandaService.updateProduct(produtoDTO, userProduct.get()));
            }
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping(path = "/comandas/{id}")
    public ResponseEntity<?> deleteComandaById(@PathVariable("id") Long id) {  
        Optional<Usuario> response = comandaService.findById(id);
        if (response.isPresent()) {
            return ResponseEntity.ok(comandaService.delete(response.get()).toString());
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }
}
