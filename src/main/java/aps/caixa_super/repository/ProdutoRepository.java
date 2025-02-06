package aps.caixa_super.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aps.caixa_super.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
