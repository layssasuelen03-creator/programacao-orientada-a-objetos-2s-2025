# Sistema de Gestão de Estoque

Sistema desenvolvido em Java para gerenciamento de estoque, com persistência de dados utilizando MySQL e Hibernate.

## Objetivo

Projeto desenvolvido para aplicar conceitos de Programação Orientada a Objetos, Hibernate, JDBC, padrão DAO e integração com banco de dados MySQL.

## Tecnologias

- Java
- Hibernate
- MySQL
- Maven
- JDBC
- Padrão DAO
- Programação Orientada a Objetos

## Estrutura do Projeto

```text
Sistema de Gestão de Estoque/
├── .vscode/
├── src/
│   └── main/
│       ├── java/
│       │   └── br/
│       │       └── estoque/
│       │           ├── dao/
│       │           │   ├── CategoriaDAO.java
│       │           │   ├── FornecedorDAO.java
│       │           │   ├── MovimentacaoDAO.java
│       │           │   └── ProdutoDAO.java
│       │           ├── entity/
│       │           │   ├── Categoria.java
│       │           │   ├── Fornecedor.java
│       │           │   ├── Movimentacao.java
│       │           │   ├── Produto.java
│       │           │   ├── ProdutoDuravel.java
│       │           │   └── ProdutoPerecivel.java
│       │           ├── util/
│       │           │   └── HibernateUtil.java
│       │           └── Main.java
│       └── resources/
│           └── hibernate.cfg.xml
├── target/
└── pom.xml
```

## Como executar

### 1. Criar o banco de dados

No MySQL, crie o banco:

```sql
CREATE DATABASE estoque;
```

### 2. Configurar o Hibernate

Abra:

`src/main/resources/hibernate.cfg.xml`

e configure:

- banco: `estoque`
- usuário do MySQL
- senha do MySQL

### 3. Compilar o projeto

No terminal, dentro da pasta do projeto:

```bash
mvn clean install
```

### 4. Executar

```bash
mvn exec:java "-Dexec.mainClass=br.estoque.Main"
```

O sistema será executado diretamente pelo terminal.

## Funcionalidades

- Cadastro de categorias
- Listar categoria
- Cadastro de fornecedores
- Listar fornecedores
- Cadastro de produtos
- Listar de produtos
- Registro de movimentações de estoque
- Sair


