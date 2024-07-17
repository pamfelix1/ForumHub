# ForumHub

ForumHub é uma aplicação de fórum desenvolvida em Spring Boot que permite aos usuários registrar-se, autenticar-se e realizar operações CRUD em tópicos de discussão. Esta aplicação utiliza JWT (JSON Web Tokens) para autenticação e segurança.

## Tecnologias Utilizadas

- Java 11+
- Spring Boot 2.5.0+
- Spring Security 6.3.1
- JWT (JSON Web Tokens)
- Maven
- MySQL

## Funcionalidades

- Registro de usuário
- Autenticação de usuário
- Criação de tópicos
- Listagem de tópicos
- Atualização de tópicos
- Deleção de tópicos

## Pré-requisitos

- Java 11+
- Maven
- MySQL

## Configuração do Ambiente

1. Clone o repositório:

    ```sh
    git clone https://github.com/seu-usuario/forumhub.git
    cd forumhub
    ```

2. Configure o banco de dados MySQL:

    - Crie um banco de dados chamado `forumhub`.

    - Configure as credenciais do banco de dados no arquivo `application.properties`:

      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
      spring.datasource.username=root
      spring.datasource.password=root

      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
      ```

3. Instale as dependências do Maven e compile o projeto:

    ```sh
    mvn clean install
    ```

4. Execute a aplicação:

    ```sh
    mvn spring-boot:run
    ```

## Endpoints da API

### Registro de Usuário

- **URL:** `/auth/register`
- **Método:** `POST`
- **Corpo da Requisição:**

  ```json
  {
      "username": "testuser",
      "password": "password",
      "email": "test@example.com",
      "role": "USER"
  }
