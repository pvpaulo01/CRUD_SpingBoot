package com.desafio.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.desafio.demo.model.Creditos;

@Service
public class CreditoService {

    private final Map<Integer, Creditos> creditoMap = new HashMap<>();
    private int idCounter = 1;

    public List<Creditos> listarCreditos() {
        return new ArrayList<>(creditoMap.values());
    }

    public Creditos criarCredito(Creditos credito) {
        credito.setId(idCounter++);
        creditoMap.put(credito.getId(), credito);
        return credito;
    }

    public Creditos obterCredito(Integer id) {
        return creditoMap.get(id);
    }

    public void atualizarCredito(Integer id, Creditos credito) {
        if (creditoMap.containsKey(id)) {
            credito.setId(id);
            creditoMap.put(id, credito);
        }
        // Lógica para tratar o caso em que o crédito com o ID especificado não existe
    }

    public void deletarCredito(Integer id) {
        creditoMap.remove(id);
    }
}
