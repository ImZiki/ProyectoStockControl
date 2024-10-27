package com.es.stockcontrol.repository;

import com.es.stockcontrol.controller.api.ProveedorRepositoryAPI;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.utils.HibernateUtil;
import com.es.stockcontrol.utils.exceptions.RepositoryException;
import jakarta.persistence.EntityManager;

import java.util.List;


public class ProveedorRepository implements ProveedorRepositoryAPI {

    public EntityManager getEntityManager() {
        return HibernateUtil.getEntityManager("Stock-Control");
    }




    @Override
    public Proveedor alta(Proveedor producto) {
        try(EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RepositoryException(e.getMessage());
        }
        return null;
    }

    @Override
    public Proveedor actualizar(Proveedor producto) {
        try(EntityManager em = getEntityManager()){
            em.getTransaction().begin();
            em.merge(producto);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RepositoryException(e.getMessage());
        }
        return null;
    }



    @Override
    public Proveedor baja(Proveedor producto) {
        try(EntityManager em = getEntityManager()){
            em.getTransaction().begin();
            em.remove(producto);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RepositoryException(e.getMessage());
        }
        return null;
    }

    //Hacer get por nombre para buscar el proveedor y devolverlo al productoService
    public get(String nombreProveedor){
        try(EntityManager em = getEntityManager()){
            em.getTransaction().begin();
            Proveedor proveedor = em.find(Proveedor.class, nombreProveedor);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RepositoryException(e.getMessage());
        }
    }
    //Hacer getProovedoreProducto(idProducto) y devolver una lista de proveedores que proveen el producto

    //Hacer getTodosProveedores() y devolver una lista con todos los proveedores

}
