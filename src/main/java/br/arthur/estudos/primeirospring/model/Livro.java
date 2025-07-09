package br.arthur.estudos.primeirospring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>Livro</h1>
 * <strong>Projeto de teste. Não utilizar em produção.</strong>
 * <p>Classe model para armazenar em memória dados do livro</p>
 * @author Arthur Ribeiro
 * @version 1.0
 * @since 2025-07-08
 */
@AllArgsConstructor
@Getter
@Setter
public class Livro {
    private long id;
    private String titulo = "";
    private String autor = "";
    private int anoPublicacao;
}
