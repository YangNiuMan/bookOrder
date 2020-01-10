package cn.itcast.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "admin";
        String pwd = encodePassword(password);
        //$2a$10$fkHk5w8zaVUNB/F7wHZTuOiAo9VjhIPkkQIKf1VK4g5/plgxcaubO
        //$2a$10$0o5uVcMDuGXjLqHbd8cZGOvJJtCLVon6OWQiDOhrNsaVl0/Qhnjx6
        System.out.print(pwd);
    }
}
