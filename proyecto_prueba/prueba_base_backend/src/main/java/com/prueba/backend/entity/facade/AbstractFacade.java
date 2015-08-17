/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.backend.entity.facade;

import com.prueba.backend.exception.JPAException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 *
 * @author CarlosDaniel
 */
public abstract class AbstractFacade<T> {

    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) throws JPAException {
        EntityManager em = getEntityManager();
        try {
            em.persist(entity);
        } catch(PersistenceException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new JPAException(ex.getMessage(), ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(T entity) throws JPAException {
        EntityManager em = getEntityManager();
        try {
           em.merge(entity);
        } catch(PersistenceException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new JPAException(ex.getMessage(), ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void remove(T entity) throws JPAException {
        EntityManager em = getEntityManager();
        try {
            em.remove(em.merge(entity));
        } catch(PersistenceException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new JPAException(ex.getMessage(), ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public T find(Object id) throws JPAException {
        EntityManager em = getEntityManager();
        try {
            return em.find(entityClass, id);
        } catch(PersistenceException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new JPAException(ex.getMessage(), ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<T> findAll() throws JPAException {
        EntityManager em = getEntityManager();
        try {
            javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            return em.createQuery(cq).getResultList();
        } catch(PersistenceException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new JPAException(ex.getMessage(), ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<T> findRange(int[] range) throws JPAException {
        EntityManager em = getEntityManager();
        try {
            javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            javax.persistence.Query q = em.createQuery(cq);
            q.setMaxResults(range[1] - range[0] + 1);
            q.setFirstResult(range[0]);
            return q.getResultList();
        } catch(PersistenceException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new JPAException(ex.getMessage(), ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public int count() throws JPAException {
        EntityManager em = getEntityManager();
        try {
            javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
            cq.select(em.getCriteriaBuilder().count(rt));
            javax.persistence.Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } catch(PersistenceException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new JPAException(ex.getMessage(), ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
