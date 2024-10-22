package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.repository.ProductoRepository;
import com.es.stockcontrol.repository.ProveedorRepository;
import com.es.stockcontrol.utils.exceptions.ServiceException;

import java.time.Instant;
import java.util.Date;

public class ProductoService {
    private ProductoRepository productoRepository;
    private ProveedorRepository proveedorRepository;
    public ProductoService(){this.productoRepository = new ProductoRepository();}


    public Producto altaProducto(String categoria,String nombreProducto, String descripcionProducto, float precioSinIva, float precioConIva,int stock,String nombreProveedor) throws ServiceException {
        try{

            if(categoria == null || categoria.isEmpty()
                    && nombreProducto == null || nombreProducto.isEmpty()
                    && precioSinIva < 0.0
                    && precioConIva < precioSinIva
                    && descripcionProducto == null || descripcionProducto.isEmpty()
                    && nombreProveedor == null || nombreProveedor.isEmpty()
                    && categoria.length() < 3
                    && nombreProducto.length() < 3
                    && nombreProveedor.length() < 3){


                throw new IllegalArgumentException("No se puede ingresar los datos del producto"); // cambiar nombre de la excepcion por la propia

            }

            Proveedor proveedor = proveedorRepository.get(nombreProveedor); // hacer en el repository búsqueda por nombre

            String categoriaPart = categoria.substring(0, 3).toUpperCase();
            String nombrePart = nombreProducto.substring(0, 3).toUpperCase();
            String proveedorPart = nombreProveedor.substring(0, 3).toUpperCase();
            String idProducto = categoriaPart + nombrePart + proveedorPart;
            Date fechaAlta = Date.from(Instant.now());
            Producto producto = new Producto(idProducto, categoria,nombreProducto,descripcionProducto,precioSinIva,precioConIva,fechaAlta,stock,proveedor);

            return producto;

        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }

    }
}
