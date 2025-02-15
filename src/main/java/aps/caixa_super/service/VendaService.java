package aps.caixa_super.service;

import aps.caixa_super.DTOs.ProdutoVendaDTO;
import aps.caixa_super.DTOs.VendaRequestDTO;
import aps.caixa_super.model.Produto;
import aps.caixa_super.model.Venda;
import aps.caixa_super.repository.ProdutoRepository;
import aps.caixa_super.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VendaService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Transactional
    public Venda realizarVenda(VendaRequestDTO vendaRequest) {
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (ProdutoVendaDTO produtoVendaDTO : vendaRequest.getProdutos()) {
            // Busca o produto no banco de dados
            Produto produto = produtoRepository.findById(produtoVendaDTO.getProdutoId())
                    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com ID: " + produtoVendaDTO.getProdutoId()));

            // Verifica se há estoque suficiente
            if (produto.getQuantidade() < produtoVendaDTO.getQuantidade()) {
                throw new IllegalArgumentException("Quantidade insuficiente do produto: " + produto.getNome());
            }

            // Calcula o valor do produto na venda
            BigDecimal valorProduto = produto.getPrecoUnitario()
                    .multiply(BigDecimal.valueOf(produtoVendaDTO.getQuantidade()));
            valorTotal = valorTotal.add(valorProduto);

            // Atualiza o estoque e salva
            System.out.println("Quantidade antes da venda: " + produto.getQuantidade());
            produto.setQuantidade(produto.getQuantidade() - produtoVendaDTO.getQuantidade());
            System.out.println("Quantidade após a venda: " + produto.getQuantidade());
            produtoRepository.save(produto);
        }

        // Criando a venda
        Venda venda = new Venda();
        venda.setDataDeVenda(LocalDateTime.now());
        venda.setValorTotal(valorTotal);

        return vendaRepository.save(venda);
    }
}