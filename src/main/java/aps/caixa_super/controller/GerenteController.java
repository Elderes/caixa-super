package aps.caixa_super.controller;

import java.math.BigDecimal;
import java.util.List;

import aps.caixa_super.DTOs.request.CaixaRequestDTO;
import aps.caixa_super.DTOs.request.ProdutoRequestDTO;
import aps.caixa_super.model.Caixa;
import aps.caixa_super.model.Tipo;
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
    GerenteService gerenteService;

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/listar-produto")
    public ResponseEntity<List<Produto>> listarProdutos() {
        return gerenteService.listarProdutos();
    }

    @GetMapping("/listar-produto-maior-menor")
    public ResponseEntity<List<Produto>> listarProdutosMaiorMenor() {
        return gerenteService.ListarProdutoMaiorMenor();
    }

    @GetMapping("/listar-produto-menor-maior")
    public ResponseEntity<List<Produto>> listarProdutosMenorMaior() {
        return gerenteService.ListarProdutoMenorMaior();
    }

    @GetMapping("/listar-produto-por")
    public ResponseEntity<List<Produto>> listarProdutoPorNome(@RequestParam String nome) {
        return gerenteService.ListarProdutoPorNome(nome);
    }


    @GetMapping("/detalhar-produto/{id}") //Ajustar esse metodo com urgencia
    public ResponseEntity<Produto> detalharProduto(@PathVariable Long id) {
        return ResponseEntity.ok().body(produtoRepository.getById(id));
    }

    @GetMapping("/listar-caixas")
    public ResponseEntity<List<Caixa>> listarCaixas(){
        return gerenteService.listarCaixas();
    }
    
    @PostMapping("/criar-produto")
    public ResponseEntity <Produto> criarProduto(@Valid @RequestBody ProdutoRequestDTO produto) {
        Produto criaPoduto = gerenteService.salvaProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criaPoduto);
    }

    @PostMapping("/criar-caixa")
    public ResponseEntity <Caixa> criarCaixa(@RequestBody CaixaRequestDTO caixa) {
        Caixa criaCaixa = gerenteService.salvarCaixa(caixa);
        return ResponseEntity.status(HttpStatus.CREATED).body(criaCaixa);
    }
    
    @PutMapping("/atualizar-preco")
    public Produto atualizarProduto(@RequestParam Long id, @RequestParam BigDecimal novoPreco) {
        return gerenteService.atualizarPreco(id, novoPreco);
    }

    @DeleteMapping("/deletar-produto/{id}")
    public ResponseEntity<Void> deletarProduto(@RequestParam Long id) {
        if (!gerenteService.produtoExiste(id)) {
            return ResponseEntity.notFound().build();  // Sem essa vericacao tava retornando 204 mesmo colocando id errado
        }
        gerenteService.deletarProduto(id);
        return ResponseEntity.noContent().build(); //204
    }

    @DeleteMapping("/Deletar-caixa/{id}")
    public ResponseEntity<Void> deletarCaixa(@PathVariable Long id) {
        if (!gerenteService.caixaExiste(id)) {
            return ResponseEntity.notFound().build();  // Retorna 404 se não encontrar o caixa
        }
        gerenteService.deletarCaixa(id);
        return ResponseEntity.noContent().build();
    }
}