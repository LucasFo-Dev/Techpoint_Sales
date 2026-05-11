package com.techpoint.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.techpoint.model.Cliente;
import com.techpoint.repository.ClienteRepository;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repo;

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return repo.save(cliente);
    }

    @GetMapping
    public List<Cliente> listarTodos() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}
