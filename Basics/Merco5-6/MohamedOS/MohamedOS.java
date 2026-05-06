import facade.ComputerFacade;

import mvc.model.FileSystemModel;
import mvc.view.TerminalView;
import mvc.controller.CommandController;

public class MohamedOS {

    public static void main(String[] args) {

        ComputerFacade computer =
                new ComputerFacade();

        computer.turnComputer();

        FileSystemModel model =
                new FileSystemModel();

        TerminalView view =
                new TerminalView();

        CommandController controller =
                new CommandController(model, view);

        controller.start();
    }
}