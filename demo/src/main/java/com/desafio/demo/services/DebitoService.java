package com.desafio.demo.services;

import com.desafio.demo.model.Debitos;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DebitoService {

    private final Map<Integer, Debitos> debitoMap = new HashMap<>();
    private int idCounter = 1;

    public List<Debitos> listarDebitos() {
        return new ArrayList<>(debitoMap.values());
    }

    public Debitos criarDebito(Debitos debito) {
        debito.setId(idCounter++);
        debitoMap.put(debito.getId(), debito);
        return debito;
    }

    public Debitos obterDebito(Integer id) {
        return debitoMap.get(id);
    }

    public void atualizarDebito(Integer id, Debitos debito) {
        if (debitoMap.containsKey(id)) {
            debito.setId(id);
            debitoMap.put(id, debito);
        }
        // Lógica para tratar o caso em que o débito com o ID especificado não existe
    }

    public void deletarDebito(Integer id) {
        debitoMap.remove(id);
    }
}
