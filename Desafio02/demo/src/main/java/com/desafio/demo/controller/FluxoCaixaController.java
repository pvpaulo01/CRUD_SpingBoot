package com.desafio.demo.controller;

import com.desafio.demo.services.CreditoService;
import com.desafio.demo.shared.FluxoCaixaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fluxo-caixa") // Alterado para "/api/fluxo-caixa"
public class FluxoCaixaController {

    @Autowired
    private CreditoService creditoService; // Certifique-se de ter a injeção do serviço corretamente

    @GetMapping
    public ResponseEntity<FluxoCaixaDTO> obterFluxoCaixa() {
        Double totalPagar = creditoService.calcularTotalPagar();
        Double totalReceber = creditoService.calcularTotalReceber();

        FluxoCaixaDTO fluxoCaixaDTO = new FluxoCaixaDTO(totalPagar, totalReceber);
        return new ResponseEntity<>(fluxoCaixaDTO, HttpStatus.OK);
    }

    // ... outros métodos ...
}
