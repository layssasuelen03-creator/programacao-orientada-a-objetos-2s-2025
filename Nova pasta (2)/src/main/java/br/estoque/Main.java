
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

        // TESTE DE CONEXÃO — SEM ALTERAR NADA NO PROJETO
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            System.out.println("Conexão bem sucedida!");
            session.close();
        } catch (Exception e) {
            System.out.println("Erro ao conectar:");
            e.printStackTrace();
        }

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== SISTEMA DE ESTOQUE (HIBERNATE) =====");
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
                }

                case 2 -> {
                    List<Categoria> cats = categoriaDAO.listar();
                    cats.forEach(c -> System.out.println(c.getId() + " - " + c.getNome()));
                }

                case 3 -> {
                    System.out.print("Nome fornecedor: ");
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
                }

                case 4 -> {
                    List<Fornecedor> fs = fornecedorDAO.listar();
                    fs.forEach(f -> System.out.println(f.getId() + " - " + f.getNome()));
                }

                case 5 -> {

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();

                    System.out.print("Quantidade: ");
                    Integer qtd = Integer.parseInt(sc.nextLine());

                    System.out.print("Preço: ");
                    BigDecimal preco = new BigDecimal(sc.nextLine());

                    System.out.print("Tipo (Perecível/Durável): ");
                    String tipo = sc.nextLine();

                    Produto p;

                    if ("Perecível".equalsIgnoreCase(tipo) || "Perecivel".equalsIgnoreCase(tipo)) {
                        System.out.print("Validade (AAAA-MM-DD): ");
                        LocalDate val = LocalDate.parse(sc.nextLine());

                        p = new ProdutoPerecivel(nome, desc, qtd, preco, val);

                    } else {
                        System.out.print("Garantia (meses): ");
                        Integer gar = Integer.parseInt(sc.nextLine());

                        p = new ProdutoDuravel(nome, desc, qtd, preco, gar);
                    }

                    System.out.println("Categorias disponíveis:");
                    categoriaDAO.listar().forEach(c -> System.out.println(c.getId() + " - " + c.getNome()));

                    System.out.print("Id categoria: ");
                    String idc = sc.nextLine();

                    Categoria c = categoriaDAO.buscarPorId(Long.valueOf(idc));
                    if (c == null) {
                        System.out.println("Categoria inválida!");
                        break;
                    }
                    p.setCategoria(c);

                    System.out.println("Fornecedores disponíveis:");
                    fornecedorDAO.listar().forEach(f -> System.out.println(f.getId() + " - " + f.getNome()));

                    System.out.print("Id fornecedor: ");
                    String idf = sc.nextLine();

                    Fornecedor f = fornecedorDAO.buscarPorId(Long.valueOf(idf));
                    if (f == null) {
                        System.out.println("Fornecedor inválida!");
                        break;
                    }
                    p.setFornecedor(f);

                    produtoDAO.salvar(p);
                }

                case 6 -> produtoDAO.listar().forEach(System.out::println);

                case 7 -> {
                    System.out.print("Id produto: ");
                    Long idp = Long.parseLong(sc.nextLine());

                    // buscar pelo id (Long)
                    Produto prod = produtoDAO.buscarPorId(idp);

                    if (prod == null) {
                        System.out.println("Produto não encontrado");
                        break;
                    }

                    System.out.print("Tipo (Entrada/Saída/Ajuste): ");
                    String t = sc.nextLine();

                    System.out.print("Quantidade: ");
                    Integer q = Integer.parseInt(sc.nextLine());

                    System.out.print("Observação: ");
                    String obs = sc.nextLine();

                    Movimentacao m = new Movimentacao(prod, t, q, obs);
                    movimentacaoDAO.registrarMovimentacao(m);
                }

                case 8 -> {
                    movimentacaoDAO.listar().forEach(System.out::println);
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

