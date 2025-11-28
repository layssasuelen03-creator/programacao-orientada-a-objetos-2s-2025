package br.estoque;

import br.estoque.dao.*;
import br.estoque.entity.*;
import br.estoque.util.HibernateUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {

        // Teste de conexão
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            System.out.println("Conexão bem sucedida!");
            session.close();
        } catch (Exception e) {
            System.out.println("Erro ao conectar:");
            e.printStackTrace();
        }

        // DAOs
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== SISTEMA DE ESTOQUE =====");
            System.out.println("1 - Cadastrar Categoria");
            System.out.println("2 - Listar Categorias");
            System.out.println("3 - Cadastrar Fornecedor");
            System.out.println("4 - Listar Fornecedores");
            System.out.println("5 - Cadastrar Produto");
            System.out.println("6 - Listar Produtos");
            System.out.println("7 - Registrar Movimentação");
            System.out.println("8 - Listar Movimentações");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            String raw = sc.nextLine();
            if (raw.isBlank()) continue;

            int op;
            try {
                op = Integer.parseInt(raw.trim());
            } catch (Exception e) {
                System.out.println("Opção inválida");
                continue;
            }

            switch (op) {

                case 1 -> {
                    System.out.print("Nome da categoria: ");
                    String nome = sc.nextLine();

                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();

                    categoriaDAO.salvar(new Categoria(nome, desc));
                    break;
                }

                case 2 -> {
                    List<Categoria> cats = categoriaDAO.listar();
                    if (cats.isEmpty()) {
                        System.out.println("Nenhuma categoria cadastrada.");
                    } else {
                        cats.forEach(c -> System.out.println(c.getId() + " - " + c.getNome()));
                    }
                    break;
                }

                case 3 -> {
                    System.out.print("Nome do fornecedor: ");
                    String fn = sc.nextLine();

                    System.out.print("CNPJ: ");
                    String cnpj = sc.nextLine();

                    System.out.print("Telefone: ");
                    String tel = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Endereço: ");
                    String end = sc.nextLine();

                    fornecedorDAO.salvar(new Fornecedor(fn, cnpj, tel, email, end));
                    break;
                }

                case 4 -> {
                    List<Fornecedor> fs = fornecedorDAO.listar();
                    if (fs.isEmpty()) {
                        System.out.println("Nenhum fornecedor cadastrado.");
                    } else {
                        fs.forEach(f -> System.out.println(f.getId() + " - " + f.getNome()));
                    }
                    break;
                }

                case 5 -> {

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();

                    System.out.print("Quantidade: ");
                    Integer qtd;
                    try {
                        qtd = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Quantidade inválida");
                        break;
                    }

                    System.out.print("Preço: ");
                    BigDecimal preco;
                    try {
                        preco = new BigDecimal(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Preço inválido");
                        break;
                    }

                    System.out.print("Tipo (Perecível/Durável): ");
                    String tipo = sc.nextLine();

                    Produto p;

                    if (tipo.equalsIgnoreCase("Perecível") || tipo.equalsIgnoreCase("Perecivel")) {
                        System.out.print("Validade (AAAA-MM-DD): ");
                        LocalDate val;
                        try {
                            val = LocalDate.parse(sc.nextLine());
                        } catch (Exception e) {
                            System.out.println("Data inválida");
                            break;
                        }

                        p = new ProdutoPerecivel(nome, desc, qtd, preco, val);

                    } else {
                        System.out.print("Garantia (meses): ");
                        Integer gar;
                        try {
                            gar = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            System.out.println("Garantia inválida");
                            break;
                        }

                        p = new ProdutoDuravel(nome, desc, qtd, preco, gar);
                    }

                    System.out.println("Categorias disponíveis:");
                    categoriaDAO.listar().forEach(c -> System.out.println(c.getId() + " - " + c.getNome()));
                    System.out.print("Id categoria (obrigatório): ");
                    String idc = sc.nextLine();
                    if (idc.isBlank()) {
                        System.out.println("Categoria obrigatória.");
                        break;
                    } else {
                        Categoria c = categoriaDAO.buscarPorId(Long.valueOf(idc));
                        if (c == null) {
                            System.out.println("Categoria não encontrada.");
                            break;
                        }
                        p.setCategoria(c);
                    }

                    System.out.println("Fornecedores disponíveis:");
                    fornecedorDAO.listar().forEach(f -> System.out.println(f.getId() + " - " + f.getNome()));
                    System.out.print("Id fornecedor (obrigatório): ");
                    String idf = sc.nextLine();
                    if (idf.isBlank()) {
                        System.out.println("Fornecedor obrigatório.");
                        break;
                    } else {
                        Fornecedor fnd = fornecedorDAO.buscarPorId(Long.valueOf(idf));
                        if (fnd == null) {
                            System.out.println("Fornecedor não encontrado.");
                            break;
                        }
                        p.setFornecedor(fnd);
                    }

                    produtoDAO.salvar(p);
                    break;
                }

                case 6 -> {
                    List<Produto> produtos = produtoDAO.listar();
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        produtos.forEach(System.out::println);
                    }
                    break;
                }

                case 7 -> {
                    System.out.print("Id produto: ");
                    String idpRaw = sc.nextLine();
                    if (idpRaw.isBlank()) {
                        System.out.println("Id obrigatório.");
                        break;
                    }

                    Long idp = Long.valueOf(idpRaw);
                    Produto prod = produtoDAO.buscarPorId(idp);

                    if (prod == null) {
                        System.out.println("Produto não encontrado.");
                        break;
                    }

                    System.out.print("Tipo (Entrada/Saida/Ajuste): ");
                    String t = sc.nextLine();

                    System.out.print("Quantidade: ");
                    Integer q = Integer.parseInt(sc.nextLine());

                    System.out.print("Observação: ");                     
                    String obs = sc.nextLine();

                    Movimentacao m = new Movimentacao(prod, t, q, obs);
                    movimentacaoDAO.registrarMovimentacao(m);

                    break;
                }

                case 8 -> {
                    List<Movimentacao> movimentacoes = movimentacaoDAO.listar();

                    if (movimentacoes.isEmpty()) {
                        System.out.println("Nenhuma movimentação registrada.");
                    } else {
                        System.out.println("\n===== MOVIMENTAÇÕES =====");
                        movimentacoes.forEach(m ->
                                System.out.printf(
                                        "Produto: %s | Tipo: %s | Quantidade: %d | Observação: %s | Data: %s%n",
                                        m.getProduto().getNome(),
                                        m.getTipo(),
                                        m.getQuantidade(),
                                        m.getObservacao(),
                                        m.getDataMovimento()
                                )
                        );
                    }
                    break;
                }

                case 0 -> {
                    System.out.println("Encerrando...");
                    HibernateUtil.shutdown();
                    sc.close();
                    return;
                }

                default -> System.out.println("Opção inválida");
            }
        }
    }
}
