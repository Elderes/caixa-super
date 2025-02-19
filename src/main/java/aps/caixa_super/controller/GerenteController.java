package aps.caixa_super.controller;

import java.math.BigDecimal;
import java.util.List;

import aps.caixa_super.model.Caixa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import aps.caixa_super.model.Produto;
import aps.caixa_super.service.ProdutoService;

@RestController
@RequestMapping("/gerente")
public class GerenteController {
    @Autowired
    ProdutoService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> listarProdutos() {
        return service.listarProdutos();
    }
    
    @PostMapping("/criar-produto")
    public Produto criarProduto(@RequestBody Produto produto) {
        System.out.println("criando produto");
        return service.criarProduto(produto);
    }

    @PostMapping("/criar-caixa")
    public Caixa criarCaixa(@RequestBody Caixa caixa) {
        System.out.println("criando caixa");
        return service.criarCaixa(caixa);
    }
    
    @PutMapping("/atualizar-preco")
    public Produto atualizarProduto(@RequestParam Long id, @RequestParam BigDecimal novoPreco) {
        return service.atualizarPreco(id, novoPreco);
    }

    @DeleteMapping("/deletar")
    public void deletarProduto(@RequestParam Long id) {
        service.deletarProduto(id);
    }
     
}
