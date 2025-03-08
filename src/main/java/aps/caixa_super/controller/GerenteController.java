package aps.caixa_super.controller;

import java.math.BigDecimal;
import java.util.List;

import aps.caixa_super.DTOs.request.CaixaRequestDTO;
import aps.caixa_super.DTOs.request.ProdutoRequestDTO;
import aps.caixa_super.model.Caixa;
import aps.caixa_super.repository.ProdutoRepository;
import aps.caixa_super.service.GerenteService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import aps.caixa_super.model.Produto;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/gerente")
public class GerenteController {
    @Autowired
    GerenteService produtoService;

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/listar-produto")
    public ResponseEntity<List<Produto>> listarProdutos() {
        return produtoService.listarProdutos();
    }

//    @GetMapping("/detalhar-produto/{id}")
//    public ResponseEntity<ProdutoRequestDTO> detalharProduto(@PathVariable Long id) {
//        return ResponseEntity.ok().body(produtoRepository.getById(id));
//    }

    @GetMapping("/listar-caixas")
    public ResponseEntity<List<Caixa>> listarCaixas(){
        return produtoService.listarCaixas();
    }
    
    @PostMapping("/criar-produto")
    public ResponseEntity <Produto> criarProduto(@Valid @RequestBody ProdutoRequestDTO produto) {
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

    @DeleteMapping("/deletar-produto/{id}")
    public ResponseEntity<Void> deletarProduto(@RequestParam Long id) {
        if (!produtoService.produtoExiste(id)) {
            return ResponseEntity.notFound().build();  // Sem essa vericacao tava retornando 204 mesmo colocando id errado
        }
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build(); //204
    }

    @DeleteMapping("/Deletar-caixa/{id}")
    public ResponseEntity<Void> deletarCaixa(@PathVariable Long id) {
        if (!produtoService.caixaExiste(id)) {
            return ResponseEntity.notFound().build();  // Retorna 404 se não encontrar o caixa
        }
        produtoService.deletarCaixa(id);
        return ResponseEntity.noContent().build();
    }
}