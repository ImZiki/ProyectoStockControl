package com.es.stockcontrol.repository;

import com.es.stockcontrol.controller.api.ProveedorRepositoryAPI;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.utils.HibernateUtil;
import com.es.stockcontrol.utils.exceptions.RepositoryException;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
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
    public Proveedor get(String nombreProveedor){
        try(EntityManager em = getEntityManager()){
            String query = "SELECT p FROM Proveedor p WHERE p.nombre = '" + nombreProveedor + "'";
            em.getTransaction().begin();
            Proveedor proveedor = em.createQuery(query, Proveedor.class).getSingleResult();
            em.getTransaction().commit();
            return proveedor;
        } catch (Exception e) {
            throw new RepositoryException(e.getMessage());
        }
    }
    //Hacer getProovedoreProducto(idProducto) y devolver una lista de proveedores que proveen el producto
    public List<Proveedor> getAllProveedoresProducto(String idProducto){
        try(EntityManager em = getEntityManager()){
            String query = "SELECT p.proveedor FROM Producto p WHERE p.idProducto = " + idProducto;
            em.getTransaction().begin();
            ArrayList proveedores = new ArrayList(em.createQuery(query).getResultList());
            em.getTransaction().commit();
            return proveedores;
        }
    }
    //Hacer getTodosProveedores() y devolver una lista con todos los proveedores
    public List<Proveedor> getAllProveedores(){
        try(EntityManager em = getEntityManager()){
            String query = "SELECT * FROM Proveedor";
            em.getTransaction().begin();
            ArrayList proveedores = new ArrayList(em.createQuery(query).getResultList());
            em.getTransaction().commit();
            return proveedores;
        }
    }
}
