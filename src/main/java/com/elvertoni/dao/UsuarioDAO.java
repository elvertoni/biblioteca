package com.elvertoni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.elvertoni.modelos.Usuario;

import java.util.List;

public class UsuarioDAO {
    private EntityManagerFactory emf;

    public UsuarioDAO() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public void salvarUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Usuario Usuario = em.find(Usuario.class, id);
        em.close();
        return Usuario;
    }

    public Usuario buscarUsuarioPorNome(String nome) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome");
        query.setParameter("nome", nome);

        try {
            return (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Retorna null se nenhum usuário for encontrado com o nome fornecido
        } finally {
            em.close();
        }
    }

    public List<Usuario> buscarTodosUsuarios() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM Usuario u");
        List<Usuario> usuarios = (List<Usuario>) query.getResultList();
        em.close();
        return usuarios;
    }

    public void editarUsuario(Usuario Usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(Usuario);
        em.getTransaction().commit();
        em.close();
    }

    public void excluirUsuario(Usuario Usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Usuario = em.merge(Usuario);
        em.remove(Usuario);
        em.getTransaction().commit();
        em.close();
    }
}
