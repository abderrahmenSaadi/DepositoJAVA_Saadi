
package mvc.view;
import java.util.Scanner;
public class TerminalView {

    private Scanner scanner =
            new Scanner(System.in);

    public void showMessage(String message) {

        System.out.println(message);
    }

    public String getInput() {

        System.out.print("mohamed@os > ");

        return scanner.nextLine();
    }
}