package br.arthur.estudos.primeirospring.dto;

/**
 * <h1>LivroRequest</h1>
 * <strong>Projeto de teste. Não utilizar em produção.</strong>
 * <p>DTO com os dados do livro enviado para cadastro</p>
 * @param titulo String
 * @param autor String
 * @param anoPublicacao int
 * @author Arthur Ribeiro
 * @version 2.0
 * @since 2025-07-08
 */
public record LivroRequest(String titulo, String autor, int anoPublicacao) {}
