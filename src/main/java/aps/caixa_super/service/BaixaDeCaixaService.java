package aps.caixa_super.service;

import aps.caixa_super.model.BaixaDeCaixa;
import aps.caixa_super.model.Caixa;
import aps.caixa_super.repository.BaixaDeCaixaRepository;
import aps.caixa_super.repository.CaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaixaDeCaixaService {

    @Autowired
    private BaixaDeCaixaRepository baixaDeCaixaRepository;

    @Autowired
    private CaixaRepository caixaRepository;

    // Método para salvar uma nova baixa
    //public BaixaDeCaixa salvarBaixa(BaixaDeCaixa baixaDeCaixa) {




    //}
}
