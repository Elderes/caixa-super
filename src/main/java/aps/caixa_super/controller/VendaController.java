package aps.caixa_super.controller;

import aps.caixa_super.DTOs.request.ProdutoRequestDTO;
import aps.caixa_super.DTOs.request.VendaRequestDTO;
import aps.caixa_super.model.Produto;
import aps.caixa_super.model.Venda;
import aps.caixa_super.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
