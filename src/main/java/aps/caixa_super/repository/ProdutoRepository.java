package aps.caixa_super.repository;

import aps.caixa_super.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Método correto para buscar produtos por IDs
    Optional<Produto> findById(Long id);
}
