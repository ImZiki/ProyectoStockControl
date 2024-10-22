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
    public Proveedor alta(Proveedor producto) {
        try{
            getEntityManager();
        } catch (Exception e) {
            throw new RepositoryException("Error de BD");
        }
        return null;
    }

    @Override
    public Proveedor actualizar(Proveedor producto) {
        try{
            getEntityManager();
        } catch (Exception e) {
            throw new RepositoryException("Error de BD");
        }
        return null;
    }



    @Override
    public Proveedor baja(Proveedor producto) {
        try{
            getEntityManager();
        } catch (Exception e) {
            throw new RepositoryException("Error de BD");
        }
        return null;
    }

    //Hacer get por nombre para buscar el proveedor y devolverlo al productoService
}
