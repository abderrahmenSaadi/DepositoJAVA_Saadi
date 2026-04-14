    import java.util.Scanner;
    
    class SwitchCond {
        public static void main(String[] args) {
            int day ;
            Scanner sc = new Scanner(System.in); // Create a Scanner object to read input from the user
            System.out.println("Enter a number (1-7) to get the corresponding day of the week: "); // Prompt the user for a number
            day = sc.nextInt(); // Read the user's input as an integer
            sc.close(); // Close the Scanner object 
            String dayName; // Declare a variable to hold the name of the day
            switch (day) { // Use a switch statement to determine the name of the day based on the input number
                case 1:
                    dayName = "Monday";
                    break;
                case 2:
                    dayName = "Tuesday";
                    break;
                case 3:
                    dayName = "Wednesday";
                    break;
                case 4:
                    dayName = "Thursday";
                    break;
                case 5:
                    dayName = "Friday";
                    break;
                case 6:
                    dayName = "Saturday";
                    break;
                case 7:
                    dayName = "Sunday";
                    break;
                default:
                    dayName = "Invalid day";
            }
            System.out.println("The day is: " + dayName);
        }
    }