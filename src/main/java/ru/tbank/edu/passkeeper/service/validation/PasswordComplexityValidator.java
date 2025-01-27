package ru.tbank.edu.passkeeper.service.validation;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class PasswordComplexityValidator extends PasswordValidatorBase {

    private final static Predicate<String> pattern = Pattern.compile(
        "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$"
    ).asPredicate();


    @Override
    protected boolean isValid(String password) {
        return pattern.test(password);
    }

    @Override
    protected String getMessage() {
        return "Пароль должен быть минимум 8 символов и содержать: строчные латинские буквы, заглавные латинские буквы, цифры";
    }
}
