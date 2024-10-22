package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.repository.ProductoRepository;
import java.time.Instant;
import java.util.Date;

public class ProductoService {
    private ProductoRepository productoRepository;
    public ProductoService(){this.productoRepository = new ProductoRepository();}

    //TODO: Preguntar a Diego no sabemos que atributos recibe el metodo
    public Producto altaProducto(String categoria,String nombreProducto, String precioSinIva, String descripcionProducto, String nombreProveedor, String direccionProveedor){

        if(categoria == null || categoria.isEmpty()
                && nombreProducto == null || nombreProducto.isEmpty()
                && precioSinIva == null || precioSinIva.isEmpty()
                && descripcionProducto == null || descripcionProducto.isEmpty()
                && nombreProveedor == null || nombreProveedor.isEmpty()
                && direccionProveedor == null || direccionProveedor.isEmpty()
                && categoria.length() < 3
                && nombreProducto.length() < 3
                && nombreProveedor.length() < 3){


            throw new IllegalArgumentException("No se puede ingresar los datos del producto"); // cambiar nombre de la excepcion por la propia

        }

        String categoriaPart = categoria.substring(0, 3).toUpperCase();
        String nombrePart = nombreProducto.substring(0, 3).toUpperCase();
        String proveedorPart = nombreProveedor.substring(0, 3).toUpperCase();
        String idProducto = categoriaPart + nombrePart + proveedorPart;
        Producto producto = new Producto(idProducto, restoatributos);
        Date fechaAlta = Date.from(Instant.now());

        return producto;
    }
}
