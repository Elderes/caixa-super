package aps.caixa_super.service;

import aps.caixa_super.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerenteService {
    private final ProdutoService produtoService;

    @Autowired
    public GerenteService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public Produto adicionarProdutoComoGerente(Produto produto) {
        return produtoService.criarProduto(produto);
    }
}
