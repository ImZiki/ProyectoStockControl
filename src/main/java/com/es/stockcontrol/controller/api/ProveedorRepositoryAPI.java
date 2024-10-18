package com.es.stockcontrol.controller.api;


import com.es.stockcontrol.model.Proveedor;

public interface ProveedorRepositoryAPI extends GenericRepositoryAPI<Proveedor>{
    @Override
    Proveedor insertar(Proveedor producto);
    @Override
    Proveedor actualizar(Proveedor producto);
    @Override
    Proveedor eliminar(Proveedor producto);
}
