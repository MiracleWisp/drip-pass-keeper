package ru.tbank.edu.passkeeper.exception;

public class SecretNotFoundException extends IllegalArgumentException {

    public SecretNotFoundException(String name) {
        super(String.format("Секрет %s не найден", name));
    }
}
