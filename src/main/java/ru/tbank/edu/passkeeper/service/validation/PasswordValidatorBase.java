package ru.tbank.edu.passkeeper.service.validation;

public abstract class PasswordValidatorBase implements PasswordValidator {

    @Override
    public final String validate(String password) {
        if (!isValid(password)) {
            return getMessage();
        } else {
            return null;
        }
    }

    abstract protected boolean isValid(String password);

    abstract protected String getMessage();
}
