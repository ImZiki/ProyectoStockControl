package com.es.stockcontrol.controller.impl;

import com.es.stockcontrol.controller.api.ProductoControllerAPI;
import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.service.ProductoService;
import com.es.stockcontrol.utils.exceptions.ServiceException;

import java.util.List;

public class ProductoController implements ProductoControllerAPI {
    ProductoService service = new ProductoService();

    @Override
    public RespuestaHTTP<Producto> altaProducto(String categoria,String nombreProducto, String descripcionProducto, float precioSinIva,int stock, String nombreProveedor) {
        try{
            Producto producto = service.altaProducto(categoria, nombreProducto, descripcionProducto, precioSinIva, stock, nombreProveedor);
            return producto != null ? new RespuestaHTTP<>(200, "OK", producto):
                    new RespuestaHTTP<>(400, "Bad request" ,null);
        }catch (ServiceException e){
            return new RespuestaHTTP<>(500, e.getMessage() ,null);
        }

    }

    @Override
    public RespuestaHTTP<Producto> bajaProducto(String id) {
        try{
            Producto producto = service.bajaProducto(id);
            return producto != null ? new RespuestaHTTP<>(200, "OK", producto):
                    new RespuestaHTTP<>(400, "Bad request" ,null);
        }catch (ServiceException e){
            return new RespuestaHTTP<>(500, e.getMessage() ,null);
        }
    }

    @Override
    public RespuestaHTTP<Producto> modificarNombreProducto(String id, String nuevoNombre) {
        try{
            Producto producto = service.modificarNombreProducto(id,nuevoNombre);
            return producto != null ? new RespuestaHTTP<>(200, "OK", producto):
                    new RespuestaHTTP<>(400, "Bad request" ,null);
        }catch (ServiceException e){
            return new RespuestaHTTP<>(500, e.getMessage() ,null);
        }
    }

    @Override
    public RespuestaHTTP<Producto> modificarStockProducto(String id, int nuevoStock) {
        try{
            Producto producto = service.modificarStockProducto(id,nuevoStock);
            return producto != null ? new RespuestaHTTP<>(200, "OK", producto):
                    new RespuestaHTTP<>(400, "Bad request" ,null);
        }catch (ServiceException e){
            return new RespuestaHTTP<>(500, e.getMessage() ,null);
        }
    }

    @Override
    public RespuestaHTTP<Producto> getProducto(String id) {
        try{
            Producto producto = service.getProducto(id);
            return producto != null ? new RespuestaHTTP<>(200, "OK", producto):
                    new RespuestaHTTP<>(400, "Bad request" ,null);
        }catch (ServiceException e){
            return new RespuestaHTTP<>(500, e.getMessage() ,null);
        }
    }

    @Override
    public RespuestaHTTP<List<Producto>> getProductosConStock() {
        try{
            List<Producto> productos = service.getProductosConStock();
            return productos != null ? new RespuestaHTTP<>(200, "OK", productos):
                    new RespuestaHTTP<>(400, "Bad request" ,null);
        }catch (ServiceException e){
            return new RespuestaHTTP<>(500, e.getMessage() ,null);
        }
    }

    @Override
    public RespuestaHTTP<List<Producto>> getProductosSinStock() {
        try{
            List<Producto> productos = service.getProductosSinStock();
            return productos != null ? new RespuestaHTTP<>(200, "OK", productos):
                    new RespuestaHTTP<>(400, "Bad request" ,null);
        }catch (ServiceException e){
            return new RespuestaHTTP<>(500, e.getMessage() ,null);
        }
    }
}
