package br.arthur.estudos.primeirospring.service;

import br.arthur.estudos.primeirospring.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <h1>LivroService</h1>
 * <strong>Projeto de teste. Não utilizar em produção.</strong>
 * <p>
 *     Arquitetar todas as funcionalidades do projeto e conexão com model.
 * </p>
 * @author Arthur Ribeiro
 * @version 1.0
 * @since 2025-07-08
 */
@Service
public class LivroService {
    private final Livro livro;

    // Construtor
    @Autowired
    public LivroService(Livro livro){
        this.livro = livro;
    }


}
