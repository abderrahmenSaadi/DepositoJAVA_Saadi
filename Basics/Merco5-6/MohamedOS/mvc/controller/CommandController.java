
package mvc.controller;
import java.util.List;
import mvc.model.FileSystemModel;
import mvc.view.TerminalView;

import lexer.Lexer;
import lexer.Token;

import commands.CommandParser;

public class CommandController {

    private FileSystemModel model;

    private TerminalView view;

    private Lexer lexer;

    private CommandParser parser;

    public CommandController(
            FileSystemModel model,
            TerminalView view
    ) {

        this.model = model;

        this.view = view;

        this.lexer = new Lexer();

        this.parser = new CommandParser();
    }

    public void start() {

        boolean running = true;

        while (running) {

            String input = view.getInput();

            if (input.trim().isEmpty()) {

                continue;
            }

            List<Token> tokens =
                    lexer.tokenize(input);

            String command =
                    tokens.get(0).getValue();

            if (!parser.isValid(command)) {

                view.showMessage(
                        "Lexical/Syntax Error: Unknown command.\n" +
                        "Type 'help' for available commands."
                );

                continue;
            }

            switch (command) {

                case "help":

                    showHelp();

                    break;

                case "ls":

                    view.showMessage(model.ls());

                    break;

                case "pwd":

                    view.showMessage(model.pwd());

                    break;

                case "mkdir":

                    if (tokens.size() < 2) {

                        view.showMessage(
                                "Usage: mkdir <folderName>"
                        );

                        break;
                    }

                    view.showMessage(
                            model.mkdir(
                                    tokens.get(1).getValue()
                            )
                    );

                    break;

                case "touch":

                    if (tokens.size() < 2) {

                        view.showMessage(
                                "Usage: touch <fileName>"
                        );

                        break;
                    }

                    view.showMessage(
                            model.touch(
                                    tokens.get(1).getValue()
                            )
                    );

                    break;

                case "rm":

                    if (tokens.size() < 2) {

                        view.showMessage(
                                "Usage: rm <name>"
                        );

                        break;
                    }

                    view.showMessage(
                            model.rm(
                                    tokens.get(1).getValue()
                            )
                    );

                    break;

                case "cd":

                    if (tokens.size() < 2) {

                        view.showMessage(
                                "Usage: cd <directory>"
                        );

                        break;
                    }

                    view.showMessage(
                            model.cd(
                                    tokens.get(1).getValue()
                            )
                    );

                    break;

                case "shutdown":

                    view.showMessage(
                            "Shutting down MohamedOS..."
                    );

                    running = false;

                    break;
            }
        }
    }

    private void showHelp() {

        view.showMessage(
                "Available Commands:\n" +
                "help               -> Show commands\n" +
                "ls                 -> List files\n" +
                "pwd                -> Show current path\n" +
                "mkdir <name>       -> Create folder\n" +
                "touch <file>       -> Create file\n" +
                "rm <name>          -> Delete file/folder\n" +
                "cd <folder>        -> Change directory\n" +
                "shutdown           -> Turn off system"
        );
    }
}