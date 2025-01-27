package ru.tbank.edu.passkeeper;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import ru.tbank.edu.passkeeper.repository.LocalSecretRepository;
import ru.tbank.edu.passkeeper.service.CommandExecutor;
import ru.tbank.edu.passkeeper.service.SecretService;
import ru.tbank.edu.passkeeper.service.command.AddCommand;
import ru.tbank.edu.passkeeper.service.command.DeleteCommand;
import ru.tbank.edu.passkeeper.service.command.LoadCommand;
import ru.tbank.edu.passkeeper.service.command.SaveCommand;
import ru.tbank.edu.passkeeper.service.command.ShowCommand;
import ru.tbank.edu.passkeeper.service.file.ConverterProvider;
import ru.tbank.edu.passkeeper.service.file.FileService;
import ru.tbank.edu.passkeeper.service.file.converter.CsvFileConverter;
import ru.tbank.edu.passkeeper.service.file.converter.JsonFileConverter;
import ru.tbank.edu.passkeeper.service.validation.PasswordComplexityValidator;
import ru.tbank.edu.passkeeper.service.validation.PasswordValidator;
import ru.tbank.edu.passkeeper.service.validation.TooCommonPasswordValidator;

public class Main {

    public static void main(String[] args) {
        List<PasswordValidator> validators = List.of(
            new PasswordComplexityValidator(),
            new TooCommonPasswordValidator()
        );
        var secretRepository = new LocalSecretRepository();
        var converterProvider = new ConverterProvider(
            Map.of(
                "json", new JsonFileConverter(new ObjectMapper()),
                "csv", new CsvFileConverter()
            )
        );
        var fileService = new FileService(converterProvider, secretRepository);
        var secretService = new SecretService(secretRepository, validators);
        var executor = new CommandExecutor(Map.of(
            "add", new AddCommand(secretService),
            "delete", new DeleteCommand(secretService),
            "show", new ShowCommand(secretService),
            "load", new LoadCommand(fileService),
            "save", new SaveCommand(fileService)
        ));
        var application = new Application(executor);
        application.run();
    }
}
