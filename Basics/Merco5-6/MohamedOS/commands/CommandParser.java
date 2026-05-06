package commands;

import java.util.Arrays;
import java.util.List;

public class CommandParser {

    private final List<String> validCommands =
            Arrays.asList(
                    "help",
                    "ls",
                    "pwd",
                    "mkdir",
                    "rm",
                    "touch",
                    "cd",
                    "shutdown"
            );

    public boolean isValid(String command) {

        return validCommands.contains(command);
    }
}