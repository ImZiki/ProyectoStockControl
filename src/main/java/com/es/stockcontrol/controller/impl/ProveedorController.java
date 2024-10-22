package com.es.stockcontrol.controller.impl;

import com.es.stockcontrol.controller.api.ProveedorControllerAPI;
import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.service.ProductoService;
import com.es.stockcontrol.service.ProveedorService;
import com.es.stockcontrol.utils.exceptions.ServiceException;
import org.hibernate.query.criteria.JpaRoot;

import java.util.List;

public class ProveedorController implements ProveedorControllerAPI {
    ProveedorService service = new ProveedorService();
    @Override
    public RespuestaHTTP<List<Proveedor>> getProveedoresProducto(String idProducto) {
        try{
            List<Proveedor> proveedor = service.getProveedoresProducto(idProducto);
            return proveedor != null ? new RespuestaHTTP<>(200, "OK", proveedor):
                    new RespuestaHTTP<>(400, "Bad request" ,null);
        }catch (ServiceException e){
            return new RespuestaHTTP<>(500, e.getMessage() ,null);
        }
    }

    @Override
    public RespuestaHTTP<List<Proveedor>> getTodosProveedores() {
        try{
            List<Proveedor> proveedor = service.getTodosProveedores();
            return proveedor != null ? new RespuestaHTTP<>(200, "OK", proveedor):
                    new RespuestaHTTP<>(400, "Bad request" ,null);
        }catch (ServiceException e){
            return new RespuestaHTTP<>(500, e.getMessage() ,null);
        }

    }
}
