package com.desafio.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.desafio.demo.model.Debitos;
import com.desafio.demo.services.DebitoService;
import java.util.List;

@RestController
@RequestMapping("/api/debitos")
public class DebitoController {

    @Autowired
    private DebitoService debitoService;

    @GetMapping
    public ResponseEntity<List<Debitos>> listarDebitos() {
        List<Debitos> debitos = debitoService.listarDebitos();
        return new ResponseEntity<>(debitos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Debitos> obterDebito(@PathVariable Integer id) {
        Debitos debito = debitoService.obterDebito(id);
        if (debito != null) {
            return new ResponseEntity<>(debito, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Debitos> criarDebito(@RequestBody Debitos debito) {
        Debitos novoDebito = debitoService.criarDebito(debito);
        return new ResponseEntity<>(novoDebito, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarDebito(@PathVariable Integer id, @RequestBody Debitos debito) {
        debitoService.atualizarDebito(id, debito);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDebito(@PathVariable Integer id) {
        debitoService.deletarDebito(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
