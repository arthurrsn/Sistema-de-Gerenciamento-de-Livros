package br.arthur.estudos.primeirospring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h1>Livro</h1>
 * <strong>Projeto de teste. Não utilizar em produção.</strong>
 * <p>Classe model para armazenar em memória dados do livro</p>
 * @author Arthur Ribeiro
 * @version 2.0
 * @since 2025-07-08
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo = "";
    private String autor = "";
    private int anoPublicacao;
}
