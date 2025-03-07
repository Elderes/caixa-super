package aps.caixa_super.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import aps.caixa_super.DTOs.mapper.CaixaMapper;
import aps.caixa_super.DTOs.mapper.ProdutoMapper;
import aps.caixa_super.DTOs.request.CaixaRequestDTO;
import aps.caixa_super.DTOs.request.ProdutoRequestDTO;
import aps.caixa_super.model.Caixa;
import aps.caixa_super.repository.CaixaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import aps.caixa_super.model.Produto;
import aps.caixa_super.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class GerenteService {
    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CaixaRepository caixaRepository;

    @Autowired
    ProdutoMapper produtoMapper;

    @Autowired
    CaixaMapper caixaMapper;

//    @Transactional
//    public Caixa criarCaixa(Caixa caixa) {
//        return caixaRepository.save(caixa);
//    }


    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok().body(produtoRepository.findAll());
    }
//    public ResponseEntity<Produto> detalharProduto(@PathVariable Long id) {
//        return ResponseEntity.ok().body(produtoRepository.getById(id));
//    }
    public ResponseEntity<List<Caixa>> listarCaixas(){
        return ResponseEntity.ok().body(caixaRepository.findAll());
    }

//    @Transactional
//    public Produto criarProduto(Produto produto) {
//        return produtoRepository.save(produto);
//    }

    @Transactional
    public Produto salvaProduto(ProdutoRequestDTO produtoRequestDTO){
        Produto produto = produtoMapper.toEntity(produtoRequestDTO);
        return produtoRepository.save(produto);
    }

    @Transactional
    public Caixa salvarCaixa(CaixaRequestDTO caixaRequestDTO){
        Caixa caixa = caixaMapper.toEntity(caixaRequestDTO);
        return caixaRepository.save(caixa);
    }

    public Produto atualizarPreco(Long id, BigDecimal novoPreco) {
        Optional<Produto> produto = produtoRepository.findById(id);
        produto.get().setPrecoUnitario(novoPreco);

        return produtoRepository.save(produto.get());
    }
    
     //Atualizar as outras coisas


    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
    public boolean produtoExiste(Long id) {
        return produtoRepository.existsById(id);
    }

    public void deletarCaixa(Long id){
        caixaRepository.deleteById(id);
    }
    public boolean caixaExiste(Long id) {
        return produtoRepository.existsById(id);
    }
}
