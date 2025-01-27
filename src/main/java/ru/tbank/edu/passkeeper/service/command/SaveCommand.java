package ru.tbank.edu.passkeeper.service.command;

import java.util.List;
import ru.tbank.edu.passkeeper.service.file.FileService;

public class SaveCommand implements Command {

    private final FileService fileService;

    public SaveCommand(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public String execute(List<String> args) {
        fileService.saveToFile(args.getFirst());
        return "Секреты сохранены в файл " + args.getFirst();
    }
}
