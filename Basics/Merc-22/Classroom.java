import java.util.ArrayList;
import java.util.Scanner;

public class Classroom {

    // ✅ Safe integer input
    public static int readInt(Scanner scanner, String message) {
        int value;

        while (true) {
            System.out.print(message);

            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); // clear buffer
                return value;
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // clear wrong input
            }
        }
    }

    // ✅ Safe string input
    public static String readString(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add student");
            System.out.println("2. Show all students");
            System.out.println("3. Modify student grade");
            System.out.println("4. Search student by name");
            System.out.println("0. Exit");

            choice = readInt(scanner, "Choice: ");

            switch (choice) {

                case 1:
                    String name = readString(scanner, "Enter name: ");

                    int grade;
                    while (true) {
                        grade = readInt(scanner, "Enter grade (0-10): ");
                        if (grade >= 0 && grade <= 10) {
                            break;
                        } else {
                            System.out.println("Grade must be between 0 and 10.");
                        }
                    }

                    students.add(new Student(name, grade));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        for (Student st : students) {
                            System.out.println(st);
                        }
                    }
                    break;

                case 3:
                    String searchName = readString(scanner, "Enter student name: ");
                    boolean found = false;

                    for (Student st : students) {
                        if (st.getName().equalsIgnoreCase(searchName)) {

                            int newGrade;
                            while (true) {
                                newGrade = readInt(scanner, "Enter new grade (0-10): ");
                                if (newGrade >= 0 && newGrade <= 10) {
                                    break;
                                } else {
                                    System.out.println("Grade must be between 0 and 10.");
                                }
                            }

                            st.setGrade(newGrade);
                            System.out.println("Updated: " + st);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    String nameSearch = readString(scanner, "Enter name to search: ");
                    boolean foundSearch = false;

                    for (Student st : students) {
                        if (st.getName().equalsIgnoreCase(nameSearch)) {
                            System.out.println("Found: " + st);
                            foundSearch = true;
                        }
                    }

                    if (!foundSearch) {
                        System.out.println("No student found with that name.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        scanner.close();
    }
}