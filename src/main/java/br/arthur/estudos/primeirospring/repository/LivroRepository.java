package br.arthur.estudos.primeirospring.repository;

import br.arthur.estudos.primeirospring.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <h1>LivroRepository</h1>
 * <strong>Projeto de teste. Não utilizar em produção.</strong>
 * <p>
 *     Interface que realiza conexão com o banco de dados por
 *     meio das credenciais colocadas no application.yml
 *     e possúi por padrão funções de CRUD
 * </p>
 * @since 2025-07-15
 * @author Arthur Ribeiro
 * @version 2.0
 */
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    // O Spring Data JPA nos permite ter funções de CRUD sem colocar a mão no código.
    // - save(Livro livro): Salva ou atualiza um Livro no DB.
    // - findById(Long id): Busca um Livro por ID.
    // - findAll(): Busca todos os Livros.
    // - deleteById(Long id): Deleta um Livro por ID.
}
