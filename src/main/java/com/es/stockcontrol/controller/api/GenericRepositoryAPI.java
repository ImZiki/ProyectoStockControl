package com.es.stockcontrol.controller.api;

import com.es.stockcontrol.model.Proveedor;

import java.util.List;

public interface GenericRepositoryAPI<T> {

    T alta(T t);
    T actualizar(T t);
    T baja(T t);
}
