package com.es.stockcontrol.repository;

import com.es.stockcontrol.controller.api.ProveedorRepositoryAPI;
import com.es.stockcontrol.model.Proveedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProveedorRepository implements ProveedorRepositoryAPI {
    private EntityManagerFactory emf;
    private EntityManager em;
    public ProveedorRepository() {
        this.emf = Persistence.createEntityManagerFactory("Stock-Control");
        this.em = emf.createEntityManager();
    }
    @Override
    public Proveedor insertar(Proveedor producto) {
        em.getTransaction().begin();
        em.persist(producto);
        em.get
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
