package br.estoque.dao;

import br.estoque.entity.Fornecedor;
import br.estoque.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FornecedorDAO {

    public void salvar(Fornecedor f) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tx = s.beginTransaction();
            s.save(f);
            tx.commit();
            System.out.println("✔ Fornecedor salvo: " + f.getNome());
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Erro ao salvar fornecedor: " + e.getMessage());
        }
    }

    // Alterado para usar Long
    public Fornecedor buscarPorId(Long id) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.get(Fornecedor.class, id);
        }
    }

    public List<Fornecedor> listar() {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createQuery("from Fornecedor", Fornecedor.class).list();
        }
    }
}
