package aps.caixa_super.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import aps.caixa_super.model.Produto;
import aps.caixa_super.repository.ProdutoRepository;

@RestController("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @GetMapping("/listar-produtos")
    public void listarProdutos() {
        for (Produto p : repository.findAll()) {
            System.out.println(p);
        }
    }
}
