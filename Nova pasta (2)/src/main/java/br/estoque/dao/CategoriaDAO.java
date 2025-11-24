package br.estoque.dao;

import br.estoque.entity.Categoria;
import br.estoque.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoriaDAO {

    public void salvar(Categoria c) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tx = s.beginTransaction();
            s.save(c);
            tx.commit();
            System.out.println("✔ Categoria salva: " + c.getNome());
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Erro ao salvar categoria: " + e.getMessage());
        }
    }

    // Alterado para usar Long (coerente com a entidade Categoria)
    public Categoria buscarPorId(Long id) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.get(Categoria.class, id);
        }
    }

    public List<Categoria> listar() {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createQuery("from Categoria", Categoria.class).list();
        }
    }
}
