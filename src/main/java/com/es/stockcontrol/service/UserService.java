package com.es.stockcontrol.service;

import com.es.stockcontrol.model.User;
import com.es.stockcontrol.repository.UserRepository;
import com.es.stockcontrol.utils.encryptUtil.PasswdEncrypter;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public User login(String nombreUsuario, String passwd){
        String hasshedPw = PasswdEncrypter.encryptPw(passwd);
        User user = userRepository.get(nombreUsuario);



    }
}
