# Sistema de Gerenciamento de Livros

Este projeto é uma aplicação back-end simples desenvolvida com Spring Boot, destinada a gerenciar o cadastro e a listagem de livros. Atualmente, os dados são armazenados exclusivamente em memória.

## 🚀 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.5.3**
    * Spring Web (para APIs REST)
    * Lombok (para reduzir boilerplate code)
    * Spring Boot DevTools (para agilizar o desenvolvimento)
* **Maven** (Gerenciador de Dependências)
* **HTML/JavaScript Puro** (para o front-end de teste)

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas (Layered Architecture), inspirada no padrão MVC, com as seguintes divisões:

* **`Controller`**: Recebe as requisições HTTP do cliente e delega as operações para a camada de serviço.
* **`Service`**: Contém a lógica de negócio principal da aplicação, processando e validando os dados.
* **`Model` (Entidades)**: Representa a estrutura dos dados do domínio (Ex: `Livro`).
* **`DTO` (Data Transfer Objects)**: Objetos utilizados para a transferência de dados entre as camadas da API e o cliente (Ex: `LivroRequest`).

## 📚 Funcionalidades Atuais

* **Cadastro de Livros:** Permite registrar novos livros com título, autor e ano de publicação.
* **Listagem de Livros:** Retorna todos os livros cadastrados na memória.

## ▶️ Como Rodar o Projeto

1.  **Clone (ou Baixe) o Repositório:** Se este fosse um projeto Git, você o clonaria. Como está localmente, apenas certifique-se de ter todos os arquivos.
2.  **Abra no IDE:** Importe o projeto no seu IDE favorito (IntelliJ IDEA, Eclipse, VS Code).
3.  **Rode a Aplicação Back-end:**
    * Navegue até a classe principal `br.arthur.estudos.primeirospring.PrimeiroSpringApplication.java`.
    * Execute o método `main` desta classe.
    * O servidor Spring Boot será iniciado na porta padrão `8080`.
4.  **Acesse o Front-end:**
    * Abra o arquivo `index.html` (localizado em `src/main/resources/static/`) diretamente no seu navegador.
    * A URL será `http://localhost:8080/`.

## 🧪 Endpoints da API

A aplicação back-end expõe os seguintes endpoints REST:

* **POST /livros**
    * **Descrição:** Cadastra um novo livro.
    * **Corpo da Requisição (JSON):**
        ```json
        {
            "titulo": "O Senhor dos Anéis",
            "autor": "J.R.R. Tolkien",
            "anoPublicacao": 1954
        }
        ```
    * **Retorno (JSON):** O objeto `Livro` cadastrado, incluindo o `id` gerado.

* **GET /livros**
    * **Descrição:** Lista todos os livros cadastrados.
    * **Retorno (JSON):** Uma lista de objetos `Livro`.
        ```json
        [
            {
                "id": 1,
                "titulo": "O Pequeno Príncipe",
                "autor": "ANTOINE DE SAINT-EXUPERY",
                "anoPublicacao": 1943
            },
            {
                "id": 2,
                "titulo": "O Hobbit",
                "autor": "J.R.R. TOLKIEN",
                "anoPublicacao": 1937
            }
        ]
        ```

---
*Este é um projeto de estudo e não deve ser utilizado em produção.*
