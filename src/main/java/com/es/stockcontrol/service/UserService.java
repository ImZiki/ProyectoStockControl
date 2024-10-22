package com.es.stockcontrol.service;

import com.es.stockcontrol.model.User;
import com.es.stockcontrol.repository.UserRepository;
import com.es.stockcontrol.utils.encryptUtil.PasswdEncrypter;
import com.es.stockcontrol.utils.exceptions.ServiceException;

import java.sql.SQLException;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public User login(String nombreUsuario, String passwd) throws ServiceException {
        try{
            if(passwd.isEmpty() || passwd == null || passwd.isEmpty()
            || nombreUsuario.isEmpty() || nombreUsuario == null){
                throw new IllegalArgumentException("Error de combinación usuario/contraseña");
            }
            String hasshedPw = PasswdEncrypter.encryptPw(passwd);
            User user = userRepository.get(nombreUsuario);
            if(user != null) {
                if (user.getContrasenia().equals(hasshedPw)) {
                    return user;
                }else{
                    throw new NullPointerException("Error de combinación usuario/contraseña");
                }
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        return null;
    }

    public User insert(String nombreUsuario, String passwd) throws ServiceException {
        try{
            if(passwd.isEmpty() || passwd == null || nombreUsuario.isEmpty() || nombreUsuario == null)
                throw new IllegalArgumentException("Contraseña/Nombre de usuario vacíos");
            String hasshedpw = PasswdEncrypter.encryptPw(passwd);
            User user = userRepository.get(nombreUsuario);
            if(user != null)
                throw new SQLException("Usuario ya existente");
            user = new User(nombreUsuario, hasshedpw);

            return userRepository.insert(user);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public User delete(String nombreUsuario) throws ServiceException {
        try{
            if(nombreUsuario.isEmpty() || nombreUsuario == null){
                throw new IllegalArgumentException("Usuario no existe");
            }
            User user = userRepository.get(nombreUsuario);
            if(user == null){
                throw new NullPointerException("Usuario no existe");
            }

            return userRepository.delete(user);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public User update(String nombreUsuario, String passwd) throws ServiceException {
        try{
            if(nombreUsuario.isEmpty() || nombreUsuario == null)
                throw new IllegalArgumentException("Nombre de usuario no válido");
            else if (passwd.isEmpty() || passwd == null || passwd.isEmpty())
                throw new IllegalArgumentException("La contraseña nueva no puede estar vacía");
            User user = userRepository.get(nombreUsuario);
            if(user == null)
                throw new NullPointerException("Usuario no existe");
            String hashedpasswd = PasswdEncrypter.encryptPw(passwd);
            user.setContrasenia(hashedpasswd);
            return userRepository.update(user);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
