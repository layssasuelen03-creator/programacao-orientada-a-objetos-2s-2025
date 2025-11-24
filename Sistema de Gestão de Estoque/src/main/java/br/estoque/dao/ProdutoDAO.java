package br.estoque.dao;

import br.estoque.entity.Produto;
import br.estoque.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProdutoDAO {

    public void salvar(Produto p) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tx = s.beginTransaction();
            s.save(p);
            tx.commit();
            System.out.println("✔ Produto salvo: " + p.getNome());
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Erro ao salvar produto: " + e.getMessage());
        }
    }

    public Produto buscarPorId(Long id) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.get(Produto.class, id);
        }
    }


    public List<Produto> listar() {
    try (Session s = HibernateUtil.getSessionFactory().openSession()) {

        return s.createQuery(
                "select p from Produto p " +
                "left join fetch p.categoria " +
                "left join fetch p.fornecedor",
                Produto.class
        ).list();
    }
}


    public void atualizar(Produto p) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tx = s.beginTransaction();
            s.update(p);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }
}
