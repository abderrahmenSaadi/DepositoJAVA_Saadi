package Basics;
import java.util.Scanner;
// This program calculates the total of grades entered by the user and categorizes them as insufficient, sufficient, or excellent based on their value.
public class exerciceGrades {
    public static void main(String[] args) {
        int numberOfGrades;
        int grade;
        int totalOfGrades = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of grades: ");// Input validation
        numberOfGrades = sc.nextInt();

        while (numberOfGrades <= 0) {
            System.out.println("Please enter a positive number: "); // Prompt user again if input is invalid
            numberOfGrades = sc.nextInt();
        }

        for (int i = 1; i <= numberOfGrades; i++) {
            System.out.println("Enter grade " + i + ": ");
            grade = sc.nextInt();

            if (grade < 0 || grade > 30) {
                System.out.println("Invalid grade. Try again.");

            }

            if (grade < 18) {
                System.out.println("Grade " + i + " is not sufficient.");
                 totalOfGrades ++;
            } else if (grade <= 24) {
                System.out.println("Grade " + i + " is sufficient.");
                 totalOfGrades ++;
            } else if (grade <= 30) {
                System.out.println("Grade " + i + " is excellent.");
                 totalOfGrades ++;
            }
        }

        System.out.println("Total sum of correct grades: " + totalOfGrades);
    }
}