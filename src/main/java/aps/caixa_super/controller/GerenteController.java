package aps.caixa_super.controller;

import java.math.BigDecimal;
import java.util.List;

import aps.caixa_super.DTOs.request.CaixaRequestDTO;
import aps.caixa_super.DTOs.request.ProdutoRequestDTO;
import aps.caixa_super.model.Caixa;
import aps.caixa_super.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import aps.caixa_super.model.Produto;

@RestController
@RequestMapping("/gerente")
public class GerenteController {
    @Autowired
    GerenteService produtoService;

    @GetMapping("/listar-produto")
    public ResponseEntity<List<Produto>> listarProdutos() {
        return produtoService.listarProdutos();
    }
    
    @PostMapping("/criar-produto")
    public ResponseEntity <Produto> criarProduto(@RequestBody ProdutoRequestDTO produto) {
        Produto criaPoduto = produtoService.salvaProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criaPoduto);
    }

    @PostMapping("/criar-caixa")
    public ResponseEntity <Caixa> criarCaixa(@RequestBody CaixaRequestDTO caixa) {
        Caixa criaCaixa = produtoService.salvarCaixa(caixa);
        return ResponseEntity.status(HttpStatus.CREATED).body(criaCaixa);
    }
    
    @PutMapping("/atualizar-preco")
    public Produto atualizarProduto(@RequestParam Long id, @RequestParam BigDecimal novoPreco) {
        return produtoService.atualizarPreco(id, novoPreco);
    }

    @DeleteMapping("/deletar-produto")
    public void deletarProduto(@RequestParam Long id) {
        produtoService.deletarProduto(id);
    }

    @DeleteMapping("/Deletar-caixa")
    public void deletarCaixa(@RequestParam Long id) {
        produtoService.deletarCaixa(id);
    }

     
}
