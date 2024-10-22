package com.es.stockcontrol.utils.encryptUtil;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswdEncrypter {
        /**
         * Metodo que recibe el password sin encriptar y procede a encriptarla
         * usando un algoritmo Hash
         * @param password contraseña sin encriptar
         * @return contraseña encriptada
         */

    public static String encryptPw(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder passwordHashed = new StringBuilder();

            for (byte b : hashBytes) {
                String hex = String.format("%02x", b);
                passwordHashed.append(hex);
            }

            return passwordHashed.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}

