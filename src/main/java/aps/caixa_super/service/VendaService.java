package aps.caixa_super.service;

import aps.caixa_super.DTOs.request.ProdutoVendaDTO;
import aps.caixa_super.DTOs.request.VendaRequestDTO;
import aps.caixa_super.model.Produto;
import aps.caixa_super.model.Venda;
import aps.caixa_super.repository.ProdutoRepository;
import aps.caixa_super.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.transaction.annotation.Transactional;

import aps.caixa_super.model.Caixa;
import aps.caixa_super.repository.CaixaRepository;

@Service
public class VendaService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private CaixaRepository caixaRepository;

    //Colocar mapper

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
            produto.setQuantidade(produto.getQuantidade() - produtoVendaDTO.getQuantidade());
            produtoRepository.save(produto);
        }

        // Busca o caixa pelo ID
        Caixa caixa = caixaRepository.findById(vendaRequest.getCaixaId())
                .orElseThrow(() -> new IllegalArgumentException("Caixa não encontrado com ID: " + vendaRequest.getCaixaId()));

        // Atualiza o saldo do caixa
        caixa.setQuantiaArmazenada(caixa.getQuantiaArmazenada().add(valorTotal));
        caixaRepository.save(caixa);

        // Criando a venda
        Venda venda = new Venda();
        venda.setDataDeVenda(LocalDateTime.now());
        venda.setValorTotal(valorTotal);
        venda.setCaixa(caixa);

        return vendaRepository.save(venda);
    }

//Deletar venda???

}
