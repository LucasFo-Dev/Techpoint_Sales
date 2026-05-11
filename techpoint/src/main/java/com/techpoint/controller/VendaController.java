package com.techpoint.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.techpoint.model.Venda;
import com.techpoint.repository.VendaRepository;
import com.techpoint.service.VendaService;
import java.util.*;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private VendaRepository vendaRepo;

    @PostMapping
    public Venda criar(@RequestBody Map<String, Object> body) {
        Long clienteId = ((Number) body.get("clienteId")).longValue();
        Long produtoId = ((Number) body.get("produtoId")).longValue();
        Integer quantidade = (Integer) body.get("quantidade");

        return vendaService.registrarVenda(clienteId, produtoId, quantidade);
    }

    @GetMapping
    public List<Venda> listarTodas() {
        return vendaRepo.findAll();
    }

    @GetMapping("/cliente/{id}")
    public List<Venda> listarPorCliente(@PathVariable Long id) {
        return vendaRepo.findByClienteId(id);
    }

    @GetMapping("/produto/{id}")
    public List<Venda> listarPorProduto(@PathVariable Long id) {
        return vendaRepo.findByProdutoId(id);
    }
}
