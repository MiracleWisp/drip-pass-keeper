package ru.tbank.edu.passkeeper.service.command;

import java.util.List;
import ru.tbank.edu.passkeeper.exception.SecretNotFoundException;
import ru.tbank.edu.passkeeper.service.SecretService;

public class ShowCommand implements Command {

    private final SecretService secretService;

    public ShowCommand(SecretService secretService) {
        this.secretService = secretService;
    }

    @Override
    public String execute(List<String> args) {
        var secret = secretService.find(args.getFirst());
        if (secret == null) {
            throw new SecretNotFoundException(args.getFirst());
        }
        return secret.toString();
    }
}
