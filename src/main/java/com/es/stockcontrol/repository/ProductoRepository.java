package com.es.stockcontrol.repository;


import com.es.stockcontrol.controller.api.ProductoRepositoryAPI;
import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.utils.HibernateUtil;
import com.es.stockcontrol.utils.exceptions.RepositoryException;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ProductoRepository implements ProductoRepositoryAPI {


    public EntityManager getEntityManager(){return HibernateUtil.getEntityManager("Stock-Control");}

    @Override
    public Producto alta(Producto producto) {
        try(EntityManager em = getEntityManager()){
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
            return producto;
        }catch(Exception e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public Producto actualizar(Producto producto) {
        try(EntityManager em = getEntityManager()){
            em.getTransaction().begin();
            Producto productoActualizado = em.merge(producto);
            em.getTransaction().commit();
            return productoActualizado;
        } catch (Exception e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public Producto baja(Producto producto) {
        try(EntityManager em = getEntityManager()){
            em.getTransaction().begin();
            Producto productoBorrar = em.find(Producto.class, producto.getIdProducto());
            if(productoBorrar != null){
                em.remove(productoBorrar);
            }
            em.getTransaction().commit();
            return productoBorrar;
        }catch(Exception e){
            throw new RepositoryException(e.getMessage());
        }
    }

    public Producto getProducto(String idProducto){
        try(EntityManager em = getEntityManager()){
            String query = "SELECT p FROM Producto p WHERE p.id = '" + idProducto + "'";
            em.getTransaction().begin();
            Producto producto = em.find(Producto.class, idProducto);
            em.getTransaction().commit();
            return producto;
        } catch (Exception e) {
            throw new RepositoryException(e.getMessage());
        }

    }

    public List<Producto> getProductoStock(boolean stock){
        try(EntityManager em = getEntityManager()){
            String query = stock ?
                    "SELECT p FROM Producto p WHERE p.stock > 0" :
                    "SELECT p FROM Producto p WHERE p.stock <= 0";
            if(stock){
                return em.createQuery(query, Producto.class).getResultList();
            }else
                return em.createQuery(query, Producto.class).getResultList();

        }catch(Exception e){
            throw new RepositoryException(e.getMessage());
        }
    }
}
