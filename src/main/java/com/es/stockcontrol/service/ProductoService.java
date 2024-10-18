package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.repository.ProductoRepository;

public class ProductoService {
    private ProductoRepository productoRepository;
    public ProductoService(){this.productoRepository = new ProductoRepository();}

    public Producto altaProducto(String idProducto, String nombreProducto, String precioSinIva, String descripcionProducto, String nombreProveedor, String direccionProveedor){
        if(idProducto == null || idProducto.isEmpty()
                && nombreProducto == null || nombreProducto.isEmpty()
                && precioSinIva == null || precioSinIva.isEmpty()
                && descripcionProducto == null || descripcionProducto.isEmpty()
                && nombreProveedor == null || nombreProveedor.isEmpty()
                && direccionProveedor == null || direccionProveedor.isEmpty() ){

            throw new IllegalArgumentException("No se puede ingresar los datos del producto"); // cambiar nombre de la excepcion por la propia

        }
        Producto producto = new Producto(idProducto,);

        return null;
    }
}
