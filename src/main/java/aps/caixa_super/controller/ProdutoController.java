package aps.caixa_super.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aps.caixa_super.model.Produto;
import aps.caixa_super.service.ProdutoService;

@RestController
public class ProdutoController {
    @Autowired
    ProdutoService service;

    @GetMapping("/listar-produtos")
    public ResponseEntity<List<Produto>> listarProdutos() {
        return service.listarProdutos();
    }
    
    @PostMapping("/criar-produto")
    public Produto criarProduto(@RequestBody Produto produto) {
        return service.criarProduto(produto);
    }
    
    @PostMapping("/atualizar-preco")
    public Produto atualizarProduto(@RequestParam Long id, @RequestParam BigDecimal novoPreco) {
        return service.atualizarPreco(id, novoPreco);
    }

    @DeleteMapping("/deletar-produto")
    public void deletarProduto(@RequestParam Long id) {
        service.deletarProduto(id);
    }
     
}
