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
            throw new RepositoryException("Error al alta");
        }
    }

    @Override
    public Producto actualizar(Producto producto) {
        try(EntityManager em = getEntityManager()){
            em.getTransaction().begin();
            Producto productoActualizado = em.merge(producto);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RepositoryException("Error al actualizar el producto");
        }
    }

    @Override
    public Producto baja(Producto producto) {
        try(EntityManager em = getEntityManager()){
            em.getTransaction().begin();
            em.remove(producto);
            em.getTransaction().commit();
            return producto;
        }catch(Exception e){
            throw new RepositoryException("Error al borrar el producto");
        }
    }

    public Producto getProducto(String idProducto){
        try(EntityManager em = getEntityManager()){
            String query = "SELECT p FROM Producto p WHERE p.id = " + idProducto;
            return (Producto) em.createQuery(query).getSingleResult();
        } catch (Exception e) {
            throw new RepositoryException("Error al obtener los productos");
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
            throw new RepositoryException("Error al obtener los productos");
        }
    }
}
