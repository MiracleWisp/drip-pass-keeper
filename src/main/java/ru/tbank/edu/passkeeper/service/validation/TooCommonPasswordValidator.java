package ru.tbank.edu.passkeeper.service.validation;

import java.util.Set;

public class TooCommonPasswordValidator extends PasswordValidatorBase {

    private final static Set<String> commonPasswords = Set.of(
        "Qwerty123",
        "Password1",
        "Welcome1",
        "Admin123",
        "Letmein1",
        "Passw0rd",
        "Monkey123",
        "Dragon1",
        "Baseball1",
        "Superman1"
    );


    @Override
    protected boolean isValid(String password) {
        return !commonPasswords.contains(password);
    }

    @Override
    protected String getMessage() {
        return "Пароль слишком простой. Придумайте менее распространенный пароль";
    }
}
