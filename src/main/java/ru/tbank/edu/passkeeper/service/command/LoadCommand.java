package ru.tbank.edu.passkeeper.service.command;

import java.util.List;
import ru.tbank.edu.passkeeper.service.file.FileService;

public class LoadCommand implements Command {

    private final FileService fileService;

    public LoadCommand(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public String execute(List<String> args) {
        fileService.loadFromFile(args.getFirst());
        return "Секреты вычитаны из файла " + args.getFirst();
    }
}
