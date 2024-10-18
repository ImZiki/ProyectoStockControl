package com.es.stockcontrol.controller.api;

import com.es.stockcontrol.model.Producto;

public interface ProductoRepositoryAPI extends GenericRepositoryAPI<Producto> {
    @Override
    Producto insertar(Producto producto);
    @Override
    Producto actualizar(Producto producto);
    @Override
    Producto eliminar(Producto producto);
}
