package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.repository.ProductoRepository;
import com.es.stockcontrol.repository.ProveedorRepository;
import com.es.stockcontrol.utils.exceptions.ServiceException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public Producto bajaProducto(String idProducto) throws ServiceException {
        try {
            if (idProducto == null || idProducto.isEmpty())
                throw new IllegalArgumentException("Producto con ID: " + idProducto + " no existe");

            Producto producto = getProducto(idProducto); // hacer en productoRepository el get por idProducto
            if (producto == null)
                throw new NullPointerException("No se encontró el producto con ID: " + idProducto);

            productoRepository.baja(producto);
            return producto;
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public Producto modificarNombreProducto(String idProducto, String nombreProducto) throws ServiceException {
        try{
            if (idProducto == null || idProducto.isEmpty()
            && nombreProducto == null || nombreProducto.isEmpty()){
                throw new IllegalArgumentException("No se puede actualizar los datos del producto");
            }

            Producto producto = getProducto(idProducto);
            if (producto == null)
                throw new NullPointerException("No se encontro el producto con ID: " + idProducto);

            producto.setNombre(nombreProducto);
            productoRepository.actualizar(producto);

            return producto;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Producto modificarStockProducto(String idProducto, int stock) throws ServiceException {
        try{
            if (idProducto == null || idProducto.isEmpty()
            && stock < 0){
                throw new IllegalArgumentException("No se puede actualizar el stock del producto");
            }

            Producto producto = getProducto(idProducto);
            if (producto == null)
                throw new NullPointerException("No se encontro el producto con ID: " + idProducto);

            producto.setStock(stock);
            productoRepository.actualizar(producto);

            return producto;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Producto getProducto(String idProducto) throws ServiceException {
        try{
            if (idProducto == null || idProducto.isEmpty()){
                throw new IllegalArgumentException("No se puede obtener el producto");
            }

            Producto producto = productoRepository.get(idProducto);
            if (producto == null)
                throw new NullPointerException("No se encontro el producto con ID: " + idProducto);

            return producto;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public List<Producto> getProductosConStock() throws ServiceException {
        try {
            boolean stock = true;
            List<Producto> listaProductos = new ArrayList<>();
            listaProductos.add(productoRepository.getStock(stock));

            return listaProductos;
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<Producto> getProductosSinStock() throws ServiceException {
        try {
            boolean stock = false;
            List<Producto> listaProductos = new ArrayList<>();
            listaProductos.add(productoRepository.getStock(stock));

            return listaProductos;
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }
}
