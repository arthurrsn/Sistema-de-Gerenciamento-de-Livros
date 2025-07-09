package br.arthur.estudos.primeirospring.controller;

import br.arthur.estudos.primeirospring.dto.LivroRequest;
import br.arthur.estudos.primeirospring.model.Livro;
import br.arthur.estudos.primeirospring.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <h1>FirstController</h1>
 * <strong>Projeto de teste. Não utilizar em produção.</strong>
 * <p>Receber requisições do front end e retornar informações</p>
 * @author Arthur Ribeiro
 * @version 1.0
 * @since 2025-07-08
 */
@RestController
@RequestMapping("/livros")
public class LivroController {
    final LivroService livroService;

    // Construtor da classe
    @Autowired
    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    /**
     * <h1>cadastrarLivro</h1>
     * <strong>Cadastrar novos livros</strong>
     * <p>
     *     Envia para o service uma instância de Record com as informações para cadastro.
     * </p>
     * @param livroRequest Record para armazenar titulo, nome do autor e data de lançamento
     * @return Livro classe contendo as informações armazenada do livro.
     */
    @PostMapping
    public Livro cadastrarLivro(@RequestBody LivroRequest livroRequest){
        return livroService.cadastrarLivro(livroRequest);
    }

    /**
     * <h1>listarLivros</h1>
     * <strong>Listar livros que já estão no nosso sistema</strong>
     * <p>
     *     Solicita a lista de livros cadastrados no sistema para o service
     *     e recebe uma lista com os objetos.
     * </p>
     * @return List<Livro> Lista com objetos do modelo Livro.
     */
    @GetMapping
    public List<Livro> listarLivros(){
        return livroService.listarLivros();
    }

}
