import java.util.ArrayList;
import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Ask how many grades the user wants to enter
        System.out.println("===== Grade Calculator =====");
        System.out.print("Enter the number of grades you want to enter: ");
        int numberOfGrades = sc.nextInt();

        while (numberOfGrades <= 0) {
            System.out.print("Please enter a positive number: ");
            numberOfGrades = sc.nextInt();
        }

        // Read each grade and validate the value
        for (int i = 1; i <= numberOfGrades; i++) {
            System.out.print("Enter grade " + i + " (0-30): ");
            int grade = sc.nextInt();
            if (grade < 0 || grade > 30) {
                System.out.println("Invalid grade. Please enter a value between 0 and 30.");
                i--; // repeat the same index for invalid input
            } else {
                grades.add(grade);
            }
        }

        // Show the final list of grades and begin the action menu
        System.out.println("\nGrades entered: " + grades);
        System.out.println("---------------------------------");

        int option;
        do {
            printMenu();
            option = sc.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    System.out.printf("Average grade: %.2f\n", calculateAverage(grades));
                    break;
                case 2:
                    System.out.println("Max grade: " + maxGrade(grades));
                    break;
                case 3:
                    System.out.println("Min grade: " + minGrade(grades));
                    break;
                case 4:
                    checkPassFail(grades);
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a number from 1 to 5.");
                    break;
            }

            if (option != 5) {
                System.out.println("---------------------------------");
            }
        } while (option != 5);
    }

    // Print the action menu to the console
    private static void printMenu() {
        System.out.println("Choose an option:");
        System.out.println(" 1 - Calculate average");
        System.out.println(" 2 - Find max grade");
        System.out.println(" 3 - Find min grade");
        System.out.println(" 4 - Check pass/fail");
        System.out.println(" 5 - Exit");
        System.out.print("Option: ");
    }

    // Calculate the average of all entered grades
    public static float calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (float) sum / grades.size();
    }

    // Find the highest grade from the list
    public static int maxGrade(ArrayList<Integer> grades) {
        int max = grades.get(0);
        for (int grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }
        return max;
    }

    // Find the lowest grade from the list
    public static int minGrade(ArrayList<Integer> grades) {
        int min = grades.get(0);
        for (int grade : grades) {
            if (grade < min) {
                min = grade;
            }
        }
        return min;
    }

    // Print whether the grade average is sufficient or insufficient
    public static void checkPassFail(ArrayList<Integer> grades) {
        float avg = calculateAverage(grades);
        if (avg < 6) {
            System.out.println("Average grade is insufficient.");
        } else {
            System.out.println("Average grade is sufficient.");
        }
    }
}
