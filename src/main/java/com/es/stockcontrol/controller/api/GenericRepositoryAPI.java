package com.es.stockcontrol.controller.api;

public interface GenericRepositoryAPI<T> {

    T insertar(T t);
    T actualizar(T t);
    T eliminar(T t);

}
