package com.desafio.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.desafio.demo.model.Creditos;
import com.desafio.demo.services.CreditoService;

import java.util.List;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @GetMapping
    public ResponseEntity<List<Creditos>> listarCreditos() {
        List<Creditos> creditos = creditoService.listarCreditos();
        return new ResponseEntity<>(creditos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Creditos> obterCredito(@PathVariable Integer id) {
        Creditos credito = creditoService.obterCredito(id);
        if (credito != null) {
            return new ResponseEntity<>(credito, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Creditos> criarCredito(@RequestBody Creditos credito) {
        Creditos novoCredito = creditoService.criarCredito(credito);
        return new ResponseEntity<>(novoCredito, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarCredito(@PathVariable Integer id, @RequestBody Creditos credito) {
        creditoService.atualizarCredito(id, credito);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCredito(@PathVariable Integer id) {
        creditoService.deletarCredito(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
