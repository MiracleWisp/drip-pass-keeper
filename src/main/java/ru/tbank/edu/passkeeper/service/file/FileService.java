package ru.tbank.edu.passkeeper.service.file;

import java.io.File;
import java.nio.file.Files;
import lombok.SneakyThrows;
import ru.tbank.edu.passkeeper.repository.SecretRepository;

public class FileService {

    private final ConverterProvider converterProvider;
    private final SecretRepository secretRepository;

    public FileService(ConverterProvider converterProvider, SecretRepository secretRepository) {
        this.converterProvider = converterProvider;
        this.secretRepository = secretRepository;
    }

    @SneakyThrows
    public void loadFromFile(String filename) {
        var file = new File(filename);
        var extension = getFileExtension(file);
        var converter = converterProvider.getByFileExtension(extension);
        var content = Files.readString(file.toPath());
        secretRepository.deleteAll();
        secretRepository.saveAll(converter.convertFromFile(content));
    }

    @SneakyThrows
    public void saveToFile(String filename) {
        var file = new File(filename);
        var extension = getFileExtension(file);
        var converter = converterProvider.getByFileExtension(extension);
        var secrets = secretRepository.findAll();
        var fileContent = converter.convertToFile(secrets);
        Files.writeString(file.toPath(), fileContent);
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf + 1);
    }
}
