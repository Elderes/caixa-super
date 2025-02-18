//package aps.caixa_super.controller;
//
//import aps.caixa_super.model.Produto;
//import aps.caixa_super.service.GerenteService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/gerente")
//public class GerenteController {
//    private final GerenteService gerenteService;
//
//    @Autowired
//    public GerenteController (GerenteService gerenteService){
//        this.gerenteService = gerenteService;
//    }
//
//    @PostMapping("/criar-produto")
//    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto) {
//        Produto novoProduto = gerenteService.adicionarProdutoComoGerente(produto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
//    }
//}
