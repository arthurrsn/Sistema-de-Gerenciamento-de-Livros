package br.arthur.estudos.primeirospring.service;

import br.arthur.estudos.primeirospring.dto.LivroRequest;
import br.arthur.estudos.primeirospring.model.Livro;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <h1>LivroService</h1>
 * <strong>Projeto de teste. Não utilizar em produção.</strong>
 * <p>
 *     Gerencia a lógica de negócio para operações de livros, incluindo cadastro e listagem.
 * </p>
 * @author Arthur Ribeiro
 * @version 1.0
 * @since 2025-07-08
 */
@Service
public class LivroService {
    // Criando AtomicLong para armazenar os IDs.
    private final AtomicLong idCounter = new AtomicLong();
    private final List<Livro> listaLivros = new ArrayList<>();

    /**
     * <h1>cadastrarLivro</h1>
     * <strong>Realizar cadastro de livros na memória</strong>
     * <p>
     *     Utilizado para cadastrar livros. Os dados do livro estarão em um DTO (LivroRequest)
     *     e serão formatados para utilização. Lançando excessões para caso os dados não estejam conforme
     *     as regras de negócio.
     * </p>
     * @param livroRequest DTO com os dados do livro
     * @return livroAtual retornando a instancia do livro que acabamos de criar.
     * @throws IllegalArgumentException lançada para quando os param não cumprem com as regras
     */
    public Livro cadastrarLivro(LivroRequest livroRequest) throws IllegalArgumentException {
        int anoAtual = LocalDate.now().getYear();
        long livroId = idCounter.getAndIncrement(); // Pegando o valor atual do id e adicionando 1

        // Pegar valores do DTO e fazer formatação.
        String titulo = livroRequest.titulo().trim().toUpperCase();
        String autor = livroRequest.autor().trim().toUpperCase();
        int anoPublicacao = livroRequest.anoPublicacao();

        // Aplicando regras de negócio para cada atributo do DTO.
        if (titulo.isEmpty()){
            throw new IllegalArgumentException("O titulo não pode ser branco ou nulo.");
        } else if (autor.isEmpty()){
            throw new IllegalArgumentException("O autor não pode ser branco ou nulo.");
        } else if (anoPublicacao > anoAtual) {
            throw new IllegalArgumentException("O ano de publicação não pode ser maior do que o ano atual.");
        }

        Livro livroAtual = new Livro(livroId, titulo, autor, anoPublicacao);
        listaLivros.add(livroAtual);

        return livroAtual;
    }

    /**
     * <h1>listarLivros</h1>
     * <strong>Retorna uma lista com os livros em memória</strong>
     * @return listaLivros
     */
    public List<Livro> listarLivros(){
        return listaLivros;
    }


}
