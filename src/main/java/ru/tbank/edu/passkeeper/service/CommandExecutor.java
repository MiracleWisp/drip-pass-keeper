package ru.tbank.edu.passkeeper.service;

import java.util.List;
import java.util.Map;
import ru.tbank.edu.passkeeper.service.command.Command;

public class CommandExecutor {

    private final Map<String, Command> commands;

    public CommandExecutor(Map<String, Command> commands) {
        this.commands = commands;
    }

    public String execute(List<String> args) {
        return commands.get(args.getFirst()).execute(args.subList(1, args.size()));
    }
}
