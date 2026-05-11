package com.techpoint.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.techpoint.model.*;
import com.techpoint.repository.*;
import java.time.LocalDate;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private ProdutoRepository produtoRepo;

    public Venda registrarVenda(Long clienteId, Long produtoId, Integer quantidade) {
        Cliente cliente = clienteRepo.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Produto produto = produtoRepo.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (produto.getEstoque() < quantidade) {
            throw new RuntimeException("Estoque insuficiente!");
        }

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setProduto(produto);
        venda.setQuantidade(quantidade);
        venda.setPrecoUnitario(produto.getPreco());
        venda.setTotal(quantidade * produto.getPreco());
        venda.setDataVenda(LocalDate.now());

        produto.setEstoque(produto.getEstoque() - quantidade);
        produtoRepo.save(produto);

        return vendaRepo.save(venda);
    }
}
