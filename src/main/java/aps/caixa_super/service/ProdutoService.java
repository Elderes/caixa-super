package aps.caixa_super.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import aps.caixa_super.model.Caixa;
import aps.caixa_super.repository.CaixaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import aps.caixa_super.model.Produto;
import aps.caixa_super.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repository;

    @Autowired
    CaixaRepository caixaRepository;

    @Transactional
    public Caixa criarCaixa(Caixa caixa) {
        return caixaRepository.save(caixa);
    }   

    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @Transactional
    public Produto criarProduto(Produto produto) {
        return repository.save(produto);
    }


    public Produto atualizarPreco(Long id, BigDecimal novoPreco) {
        Optional<Produto> produto = repository.findById(id);
        produto.get().setPrecoUnitario(novoPreco);

        return repository.save(produto.get());
    }
    
     //Atualizar as outras coisas


    public void deletarProduto(Long id) {
        repository.deleteById(id);
    }
}
