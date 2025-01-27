package ru.tbank.edu.passkeeper.service;

import java.util.List;
import java.util.Map;
import ru.tbank.edu.passkeeper.service.command.Command;
import ru.tbank.edu.passkeeper.service.command.HelpCommand;

public class CommandExecutor {

    private final Map<String, Command> commands;
    private final HelpCommand helpCommand;

    public CommandExecutor(Map<String, Command> commands, HelpCommand helpCommand) {
        this.commands = commands;
        this.helpCommand = helpCommand;
    }

    public String execute(List<String> args) {
        var command = commands.getOrDefault(args.getFirst(), helpCommand);
        return command.execute(args.subList(1, args.size()));
    }

}
