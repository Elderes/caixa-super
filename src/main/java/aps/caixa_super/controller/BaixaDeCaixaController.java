//package aps.caixa_super.controller;
//
//import aps.caixa_super.model.BaixaDeCaixa;
//import aps.caixa_super.service.BaixaDeCaixaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/baixas")
//public class BaixaDeCaixaController {
//    @Autowired
//    private BaixaDeCaixaService baixaDeCaixaService;
//
//    // Endpoint para salvar uma nova baixa
//    @PostMapping
//    public ResponseEntity<BaixaDeCaixa> salvarBaixa(@RequestBody BaixaDeCaixa baixaDeCaixa) {
//        try {
//            BaixaDeCaixa salva = baixaDeCaixaService.salvarBaixa(baixaDeCaixa);
//            return new ResponseEntity<>(salva, HttpStatus.CREATED);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//}
