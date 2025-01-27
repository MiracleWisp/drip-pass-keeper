package ru.tbank.edu.passkeeper.service.file.converter;

import java.util.List;
import ru.tbank.edu.passkeeper.model.Secret;

public interface FileConverter {

    String convertToFile(List<Secret> secrets);

    List<Secret> convertFromFile(String fileContent);
}
