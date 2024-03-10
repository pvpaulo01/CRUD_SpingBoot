package com.desafio.demo.services;

import com.desafio.demo.model.Debitos;
import com.desafio.demo.repository.DebitosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DebitoService {

    @Autowired
    private DebitosRepository debitoRepository;

    /**
     * Lista todos os débitos.
     *
     * @return Lista de Debitos
     */
    public List<Debitos> listarDebitos() {
        return debitoRepository.findAll();
    }

    /**
     * Cria um novo débito.
     *
     * @param debito O débito a ser criado
     * @return O débito criado
     */
    @SuppressWarnings("null")
    public Debitos criarDebito(Debitos debito) {
        return debitoRepository.save(debito);
    }

    /**
     * Obtém um débito pelo ID.
     *
     * @param id O ID do débito a ser obtido
     * @return O débito encontrado ou null se não existir
     */
    public Debitos obterDebito(Integer id) {
        @SuppressWarnings("null")
        Optional<Debitos> optionalDebitos = debitoRepository.findById(id);
        return optionalDebitos.orElse(null);
    }

    /**
     * Atualiza um débito existente.
     *
     * @param id     O ID do débito a ser atualizado
     * @param debito O débito com os novos dados
     */
    @SuppressWarnings("null")
    public void atualizarDebito(Integer id, Debitos debito) {
        if (debitoRepository.existsById(id)) {
            debito.setId(id);
            debitoRepository.save(debito);
        }
        // Lógica para tratar o caso em que o débito com o ID especificado não existe
    }

    /**
     * Deleta um débito pelo ID.
     *
     * @param id O ID do débito a ser deletado
     */
    @SuppressWarnings("null")
    public void deletarDebito(Integer id) {
        debitoRepository.deleteById(id);
    }
}
