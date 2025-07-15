package br.arthur.estudos.primeirospring.service;

import br.arthur.estudos.primeirospring.dto.LivroRequest;
import br.arthur.estudos.primeirospring.model.Livro;
import br.arthur.estudos.primeirospring.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <h1>LivroService</h1>
 * <strong>Projeto de teste. Não utilizar em produção.</strong>
 * <p>
 *     Gerencia a lógica de negócio para operações de livros, incluindo cadastro e listagem.
 * </p>
 * @author Arthur Ribeiro
 * @version 2.0
 * @since 2025-07-08
 */
@Service
public class LivroService {
    private final LivroRepository livroRepository;

    // Construtor
    @Autowired
    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    /**
     * <h1>cadastrarLivro</h1>
     * <strong>Realizar cadastro de livros na memória</strong>
     * <p>
     *     Utilizado para cadastrar livros. Os dados do livro estarão em um DTO (LivroRequest)
     *     e serão formatados para utilização e armazenamento no banco de dados.
     *     Lançando excessões para caso os dados não estejam conforme as regras de negócio.
     * </p>
     * @param livroRequest DTO com os dados do livro
     * @return livroSalvo retornando a instancia do livro que acabamos de criar.
     * @throws IllegalArgumentException lançada para quando os param não cumprem com as regras
     */
    public Livro cadastrarLivro(LivroRequest livroRequest) throws IllegalArgumentException {
        int anoAtual = LocalDate.now().getYear();

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

        // Criando o livro e passando os dados, menos o ID, que será gerado automaticamente
        Livro novoLivro = new Livro(null, titulo, autor, anoPublicacao);

        // Salvar o livro no banco de dados
        Livro livroSalvo = livroRepository.save(novoLivro);

        System.out.println("LOG: Livro salvo no banco de dados: " + livroSalvo.getTitulo() + " (ID: " + livroSalvo.getId() + ")");

        // Enviando instancia do livro para o front end
        return livroSalvo;
    }

    /**
     * <h1>listarLivros</h1>
     * <strong>Retorna uma lista com todos os livros no banco de dados</strong>
     * @return listaLivros
     */
    public List<Livro> listarLivros(){
        return livroRepository.findAll();
    }


}
