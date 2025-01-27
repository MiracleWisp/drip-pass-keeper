package ru.tbank.edu.passkeeper.service.command;

import java.util.List;

public interface Command {

    String execute(List<String> args);
}
