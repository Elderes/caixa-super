package aps.caixa_super.controller;

import aps.caixa_super.DTOs.request.ProdutoRequestDTO;
import aps.caixa_super.DTOs.request.VendaRequestDTO;
import aps.caixa_super.DTOs.response.VendaResponseDTO;
import aps.caixa_super.model.Produto;
import aps.caixa_super.model.Venda;
import aps.caixa_super.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping("/realizar")
    public ResponseEntity<Venda>  realizarVenda(@RequestBody VendaRequestDTO vendaRequest) {
        Venda realizaVenda = vendaService.realizarVenda(vendaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(realizaVenda);
    }

    @GetMapping("/listar-vendas")
    public ResponseEntity<List<VendaResponseDTO>> listarVendas() {
        return vendaService.listarVendas();
    }

    @DeleteMapping("/deletar{vendaId}")
    public ResponseEntity<Void> deletarVenda(@PathVariable Long vendaId) {
        return vendaService.deletarVenda(vendaId);
    }
}
