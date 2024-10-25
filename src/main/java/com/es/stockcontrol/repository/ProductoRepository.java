package com.es.stockcontrol.repository;


import com.es.stockcontrol.controller.api.ProductoRepositoryAPI;
import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.utils.HibernateUtil;
import com.es.stockcontrol.utils.exceptions.RepositoryException;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ProductoRepository implements ProductoRepositoryAPI {

    private List<Producto> listaProductos;

    public EntityManager getEntityManager(){
        return HibernateUtil.getEntityManager("Stock-Control");
    }
    public void closeEntityManager(EntityManager em){
        HibernateUtil.closeEntityManager(em);
    }

    @Override
    public Producto alta(Producto producto) {
        return null;
    }

    @Override
    public Producto actualizar(Producto producto) {
        return null;
    }

    @Override
    public Producto baja(Producto producto) {
        return null;
    }

    public Producto get(){

    }

    public List<Producto> getStock(boolean stock){
        try{
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            if(stock){
                String consulta = "SELECT p FROM producto p WHERE p.stock > 0";
                return em.createQuery(consulta, Producto.class).getResultList();
            }else
                return null;

        }catch(Exception e){
            throw new RepositoryException(e.getMessage());
        }
    }


    //hacer get por idProducto para el productoService


}
