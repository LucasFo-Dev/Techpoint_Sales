package com.techpoint.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.techpoint.model.Produto;
import com.techpoint.repository.ProdutoRepository;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repo;

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return repo.save(produto);
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
}
