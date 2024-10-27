package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.repository.ProveedorRepository;
import com.es.stockcontrol.utils.exceptions.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class ProveedorService {
    private ProveedorRepository proveedorRepository;
    public List<Proveedor> getProveedoresProductos(String idProducto) throws ServiceException {
        try{
            if (idProducto.isEmpty() || idProducto == null){
                throw new IllegalArgumentException("No se puede obtener los proveedores a partir de esa ID de producto.");
            }
            List<Proveedor> listaproveedores = proveedorRepository.getAllProveedoresProducto(idProducto);
            return listaproveedores;
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<Proveedor> getTodosProveedores() throws ServiceException{
        try{
            List<Proveedor> listaProveedor;
            listaProveedor = new ArrayList<>(proveedorRepository.getAllProveedores());

            return listaProveedor;
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }
}
