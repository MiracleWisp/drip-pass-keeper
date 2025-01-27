package ru.tbank.edu.passkeeper.service.command;

import java.util.List;
import ru.tbank.edu.passkeeper.service.SecretService;

public class DeleteCommand implements Command {

    private final SecretService secretService;

    public DeleteCommand(SecretService secretService) {
        this.secretService = secretService;
    }

    @Override
    public String execute(List<String> args) {
        var name = args.getFirst();
        secretService.delete(name);
        return String.format("Секрет %s удален", name);
    }
}
