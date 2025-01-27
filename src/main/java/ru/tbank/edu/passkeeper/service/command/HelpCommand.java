package ru.tbank.edu.passkeeper.service.command;

import java.util.List;

public class HelpCommand implements Command {

    @Override
    public String execute(List<String> args) {
        return """
            add {name} {login} {password} - добавить секрет
            show {name} - показать секрет
            delete {name} - удалить секрет
            load {filename} - загрузить дамп из файла
            save {filename} - сохранить дамп в файл
            help - помощь
            """;
    }
}
