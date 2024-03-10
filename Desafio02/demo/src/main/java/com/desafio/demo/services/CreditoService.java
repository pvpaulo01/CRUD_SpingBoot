package com.desafio.demo.services;
import com.desafio.demo.model.Creditos;
import com.desafio.demo.repository.CreditosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditoService {

    @Autowired
    private CreditosRepository creditoRepository;

    public List<Creditos> listarCreditos() {
        return creditoRepository.findAll();
    }

    @SuppressWarnings("null")
    public Creditos criarCredito(Creditos credito) {
        return creditoRepository.save(credito);
    }

    public Creditos obterCredito(Integer id) {
        @SuppressWarnings("null")
        Optional<Creditos> optionalCreditos = creditoRepository.findById(id);
        return optionalCreditos.orElse(null);
    }

    @SuppressWarnings("null")
    public void atualizarCredito(Integer id, Creditos credito) {
        if (creditoRepository.existsById(id)) {
            credito.setId(id);
            creditoRepository.save(credito);
        }
        // Lógica para tratar o caso em que o crédito com o ID especificado não existe
    }

    @SuppressWarnings("null")
    public void deletarCredito(Integer id) {
        creditoRepository.deleteById(id);
    }


    public Double calcularTotalPagar() {
        List<Creditos> creditos = creditoRepository.findAll();
        return creditos.stream()
                .filter(credito -> credito.getValorDebito() != null)
                .mapToDouble(Creditos::getValorDebito)
                .sum();
    }
    
    public Double calcularTotalReceber() {
        List<Creditos> creditos = creditoRepository.findAll();
        return creditos.stream()
                .filter(credito -> credito.getValorPago() != null)
                .mapToDouble(Creditos::getValorPago)
                .sum();
    }
    

}
