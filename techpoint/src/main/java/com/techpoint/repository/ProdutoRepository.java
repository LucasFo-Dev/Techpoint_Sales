package com.techpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techpoint.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
