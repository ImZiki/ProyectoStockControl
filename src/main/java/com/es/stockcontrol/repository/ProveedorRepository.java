package com.es.stockcontrol.repository;

import com.es.stockcontrol.controller.api.ProveedorRepositoryAPI;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.utils.HibernateUtil;
import com.es.stockcontrol.utils.exceptions.RepositoryException;
import jakarta.persistence.EntityManager;


public class ProveedorRepository implements ProveedorRepositoryAPI {

    public EntityManager getEntityManager() {
        return HibernateUtil.getEntityManager("Stock-Control");
    }

    public void closeEntityManager(EntityManager em) {
        HibernateUtil.closeEntityManager(em);
    }
    
    @Override
    public Proveedor insertar(Proveedor producto) throws RepositoryException {
        try{
            getEntityManager()
        } catch (Exception e) {
            throw new RepositoryException("Error de BD");
        }
        return null;
    }

    @Override
    public Proveedor actualizar(Proveedor producto) {
        em.getTransaction().begin();
        return em.merge(producto);
    }

    @Override
    public Proveedor eliminar(Proveedor producto) {
        return null;
    }
}
