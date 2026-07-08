package com.library.library_management_api;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordChecker {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String storedHash =
                "$2a$10$g9Fs9b7muU5Qo/uiPi4YsuIBaDfYNoX0Ypco5/cx96gg9b9MnGyha";

        boolean result = encoder.matches("admin123", storedHash);

        System.out.println("PASSWORD MATCH RESULT = " + result);
    }
}