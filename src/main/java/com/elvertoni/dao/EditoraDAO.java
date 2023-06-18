package com.elvertoni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.elvertoni.modelos.Editora;

import java.util.List;

public class EditoraDAO {
    private EntityManagerFactory emf;

    public EditoraDAO() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public static void salvarEditora(Editora Editora) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(Editora);
        em.getTransaction().commit();
        em.close();
    }

    public Editora buscarEditoraPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Editora Editora = em.find(Editora.class, id);
        em.close();
        return Editora;
    }

    public Editora buscarEditoraPorNome(String nome) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM Editora u WHERE u.nome = :nome");
        query.setParameter("nome", nome);

        try {
            return (Editora) query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Retorna null se nenhum usuário for encontrado com o nome fornecido
        } finally {
            em.close();
        }
    }

    public List<Editora> buscarTodasEditoras() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM Editora u");
        List<Editora> Editoras = (List<Editora>) query.getResultList();
        em.close();
        return Editoras;
    }

    public void editarEditora() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(Editora);
        em.getTransaction().commit();
        em.close();
    }

    public void excluirEditora(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Editora = em.merge(Editora);
        em.remove(Editora);
        em.getTransaction().commit();
        em.close();
    }
}