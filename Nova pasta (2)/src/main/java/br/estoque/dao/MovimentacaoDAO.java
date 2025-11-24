package br.estoque.dao;

import br.estoque.entity.Movimentacao;
import br.estoque.entity.Produto;
import br.estoque.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MovimentacaoDAO {

    public boolean registrarMovimentacao(Movimentacao m) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tx = s.beginTransaction();

            Produto p = s.get(Produto.class, m.getProduto().getId());
            if (p == null) throw new RuntimeException("Produto não encontrado: " + m.getProduto().getId());

            int atual = p.getQuantidade();
            int nova = atual;

            switch (m.getTipo()) {
                case "Entrada" -> nova = atual + m.getQuantidade();
                case "Saída" -> {
                    nova = atual - m.getQuantidade();
                    if (nova < 0) throw new RuntimeException("Estoque insuficiente.");
                }
                case "Ajuste" -> nova = atual + m.getQuantidade();
                default -> throw new RuntimeException("Tipo inválido.");
            }

            p.setQuantidade(nova);
            s.update(p);

            // salvar movimentação associando o produto gerenciado
            m.setProduto(p);
            s.save(m);

            tx.commit();
            System.out.println("✔ Movimentação registrada.");
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Erro ao registrar movimentação: " + e.getMessage());
            return false;
        }
    }

    public List<Movimentacao> listar() {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createQuery("from Movimentacao order by dataMovimento desc", Movimentacao.class).list();
        }
    }
}
