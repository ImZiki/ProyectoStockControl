package com.es.stockcontrol.service;

import com.es.stockcontrol.model.User;
import com.es.stockcontrol.repository.UserRepository;
import com.es.stockcontrol.utils.encryptUtil.PasswdEncrypter;
import com.es.stockcontrol.utils.exceptions.ServiceException;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public User login(String nombreUsuario, String passwd) throws ServiceException {
        try{
            if(passwd.isEmpty() || passwd == null || passwd.isEmpty()
            || nombreUsuario.isEmpty() || nombreUsuario == null){
                throw new ServiceException("Error de combinación usuario/contraseña");
            }
            String hasshedPw = PasswdEncrypter.encryptPw(passwd);
            User user = userRepository.get(nombreUsuario);
            if(user != null) {
                if (user.getContrasenia().equals(hasshedPw)) {
                    return user;
                }else{
                    throw new ServiceException("Error de combinación ")
                }
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }




    }
}
