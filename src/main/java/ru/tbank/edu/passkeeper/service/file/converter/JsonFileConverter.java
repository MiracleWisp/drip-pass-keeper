package ru.tbank.edu.passkeeper.service.file.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.SneakyThrows;
import ru.tbank.edu.passkeeper.model.Secret;

public class JsonFileConverter implements FileConverter {

    private final ObjectMapper mapper;
    private final static TypeReference<List<Secret>> secretListTypeReference = new TypeReference<>() {
    };

    public JsonFileConverter(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    @SneakyThrows
    public String convertToFile(List<Secret> secrets) {
        return mapper.writeValueAsString(secrets);
    }

    @Override
    @SneakyThrows
    public List<Secret> convertFromFile(String fileContent) {
        return mapper.readValue(fileContent, secretListTypeReference);
    }
}
