package ru.tbank.edu.passkeeper.exception;

public class UnsupportedFormatException extends IllegalArgumentException {

    public UnsupportedFormatException(String format) {
        super(String.format("Формат %s не поддерживается", format));
    }
}
