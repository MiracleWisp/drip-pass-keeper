package ru.tbank.edu.passkeeper.service.file.converter;

import java.util.List;
import lombok.SneakyThrows;
import ru.tbank.edu.passkeeper.model.Secret;

public class CsvFileConverter implements FileConverter {

    private final static String HEADER = "name,login,password\n";

    @Override
    @SneakyThrows
    public String convertToFile(List<Secret> secrets) {
        return HEADER + secrets.stream().map(
            secret -> String.format("\"%s\",\"%s\",\"%s\"", secret.name(), secret.login(),
                secret.password()));
    }

    @Override
    @SneakyThrows
    public List<Secret> convertFromFile(String fileContent) {
        return fileContent
            .lines()
            .skip(1)
            .map(line -> {
                var columns = line.split(",\\s*");
                return new Secret(columns[0], columns[1], columns[2]);
            })
            .toList();
    }
}
