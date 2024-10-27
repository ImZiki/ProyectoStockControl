package com.es.stockcontrol.controller.impl;


import com.es.stockcontrol.controller.api.UserControllerAPI;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.model.User;
import com.es.stockcontrol.service.ProveedorService;
import com.es.stockcontrol.service.UserService;
import com.es.stockcontrol.utils.exceptions.ServiceException;

import java.util.List;

public class UserController implements UserControllerAPI {
    UserService service = new UserService();

    @Override
    public RespuestaHTTP<User> login(String userInput, String passInput) {
        try{
           User user = service.login(userInput,passInput);
            return user != null ? new RespuestaHTTP<>(200, "OK", user):
                    new RespuestaHTTP<>(400, "Bad request" ,null);
        }catch (ServiceException e){
            return new RespuestaHTTP<>(500, e.getMessage() ,null);
        }
    }

    public RespuestaHTTP<User> altaUsuario(String userInput, String passInput) {
        try{
            User user = service.insert(userInput,passInput);
            return user != null ? new RespuestaHTTP<>(200, "OK", user):
                    new RespuestaHTTP<>(400, "Bad Request", null);
        } catch (Exception e) {
            return new RespuestaHTTP<>(500, e.getMessage() ,null);
        }
    }
}
