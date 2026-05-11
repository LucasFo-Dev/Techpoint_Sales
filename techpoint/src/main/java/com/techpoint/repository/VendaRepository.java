package com.techpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techpoint.model.Venda;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByClienteId(Long clienteId);
    List<Venda> findByProdutoId(Long produtoId);
}
