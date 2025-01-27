package ru.tbank.edu.passkeeper.service.file;

import java.util.Map;
import ru.tbank.edu.passkeeper.exception.UnsupportedFormatException;
import ru.tbank.edu.passkeeper.service.file.converter.FileConverter;

public class ConverterProvider {

    private final Map<String, FileConverter> converters;

    public ConverterProvider(Map<String, FileConverter> converters) {
        this.converters = converters;
    }

    public FileConverter getByFileExtension(String extension) {
        var converter = converters.get(extension);
        if (converter == null) {
            throw new UnsupportedFormatException(extension);
        }
        return converter;
    }
}
