package ru.tbank.edu.passkeeper.service.command;

import java.util.List;
import ru.tbank.edu.passkeeper.model.Secret;
import ru.tbank.edu.passkeeper.service.SecretService;

public class AddCommand implements Command {

    private final SecretService secretService;

    public AddCommand(SecretService secretService) {
        this.secretService = secretService;
    }

    @Override
    public String execute(List<String> args) {
        var secret = new Secret(
            args.get(0),
            args.get(1),
            args.get(2)
        );
        secretService.save(secret);
        return String.format("Секрет %s сохранен", secret);
    }
}
