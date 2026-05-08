package util;

import java.util.Scanner;

public class InputValidator {

    public static int readInt(Scanner scanner) {

        while (true) {

            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid number.");
            }
        }
    }
}