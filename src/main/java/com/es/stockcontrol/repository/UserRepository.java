package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.User;
import com.es.stockcontrol.utils.HibernateUtil;
import com.es.stockcontrol.utils.exceptions.RepositoryException;
import jakarta.persistence.EntityManager;

import java.sql.SQLException;

public class UserRepository {

    public EntityManager getEntityManager(){
        return HibernateUtil.getEntityManager("Stock-Control");
    }
    public void closeEntityManager(EntityManager em){
        HibernateUtil.closeEntityManager(em);
    }

    public User insert(User user) throws RepositoryException {
        try{
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            closeEntityManager(em);
            return user;
        }catch(Exception e){
            throw new RepositoryException(e.getMessage());
        }
    }

    public User delete(User user) throws RepositoryException {
        try{
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
            closeEntityManager(em);
            return user;
        } catch (Exception e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    public User update(User user) throws RepositoryException {
        try{
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
            closeEntityManager(em);
            return user;
        }catch(Exception e){
            throw new RepositoryException(e.getMessage());
        }
    }


    public User get(String nombreUsuario)throws RepositoryException {
        try{
            EntityManager em = getEntityManager();
            User user = em.find(User.class, nombreUsuario);
            closeEntityManager(em);
            return user;
        }catch (Exception e){
            throw new RepositoryException(e.getMessage());
        }

    }

}
