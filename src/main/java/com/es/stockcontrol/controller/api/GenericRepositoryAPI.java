package com.es.stockcontrol.controller.api;

public interface GenericRepositoryAPI<T> {

    T alta(T t);
    T actualizar(T t);
    T baja(T t);

}
