package ru.tbank.edu.passkeeper;

import java.util.Arrays;
import java.util.Scanner;
import ru.tbank.edu.passkeeper.service.CommandExecutor;

public class Application {

    private final CommandExecutor commandExecutor;

    public Application(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }


    public void run() {
        var scanner = new Scanner(System.in);
        while (true) {
            var args = Arrays.asList(scanner.nextLine().split("\\s+"));
            var command = args.getFirst();
            if (command.equals("exit")) {
                break;
            }
            try {
                var result = commandExecutor.execute(args);
                System.out.println(result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
