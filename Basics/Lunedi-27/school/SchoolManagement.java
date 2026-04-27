import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class SchoolManagement {

    // ── School-wide collections (all lists are private, accessed via methods) ──
    private static final List<Student> allStudents = new ArrayList<>();
    private static final List<Teacher> allTeachers = new ArrayList<>();
    private static Director director = new Director("Dr. Smith", 55, "admin123");

    // ── Shared scanner – one instance prevents resource leaks ─────────────────
    private static final Scanner scanner = new Scanner(System.in);

    
    public static void main(String[] args) {
        preloadDemoData();        // seed system with realistic sample data
        printBanner();
        mainMenuLoop();
        System.out.println("\n  Goodbye – school dismissed!\n");
        scanner.close();
    }

    //   The main menu loop keeps the program running until the user chooses to exit.
    private static void mainMenuLoop() {
        boolean running = true;

        while (running) {
            printMainMenu();
            int choice = readInt("→ Your choice: ");

            switch (choice) {

                // ── Student management ─────────────────────────────────────
                case 1 -> addScientificStudent();
                case 2 -> addHumanitiesStudent();
                case 3 -> listAllStudents();

                // ── Teacher management ─────────────────────────────────────
                case 4 -> addSTEMTeacher();
                case 5 -> addArtsTeacher();
                case 6 -> listAllTeachers();

                // ── Enrollment ─────────────────────────────────────────────
                case 7 -> enrollStudentWithTeacher();

                // ── Grading ────────────────────────────────────────────────
                case 8 -> assignGradeFlow();

                // ── Grade reports ──────────────────────────────────────────
                case 9 -> printStudentGradesFlow();

                // ── Polymorphism showcase ──────────────────────────────────
                case 10 -> showcasePolymorphism();

                // ── Registration showcase ──────────────────────────────────
                case 11 -> showcaseRegistration();

                // ─────────── Director login ──────────────────────
                case 12 -> directorLogin();

                // ── Exit ───────────────────────────────────────────────────
                case 0 -> running = false;

                default -> System.out.println("⚠️  Invalid option. Please choose 0–11.");
            }
        }
    }


   
    private static void printBanner() {
        System.out.println("""
                
                ╔═══════════════════════════════════════════════════╗
                ║   🏫  SCHOOL MANAGEMENT SYSTEM  –  Java 2026  🏫  ║
                ║          OOP: Encapsulation · Inheritance          ║
                ║               Polymorphism · Abstraction           ║
                ╚═══════════════════════════════════════════════════╝
                """);
    }

    /** Prints the numbered main menu. */
    private static void printMainMenu() {
        System.out.println("""
                
                ┌─────────────────────────────────────────────────┐
                │                   MAIN  MENU                    │
                ├──────────────────────┬──────────────────────────┤
                │  STUDENTS            │  TEACHERS                │
                │  1) Add Scientific   │  4) Add STEM teacher     │
                │  2) Add Humanities   │  5) Add Arts teacher     │
                │  3) List all         │  6) List all             │
                ├──────────────────────┴──────────────────────────┤
                │  7) Enroll student with a teacher               │
                │  8) Assign grade (teacher → student)            │
                │  9) Print student grades                        │
                │ 10) Showcase polymorphism (describeRole)        │
                │ 11) Showcase registration (interface)           │
                │ 12) director login                              │
                │                                                 │
                │  0) Exit                                        │
                └─────────────────────────────────────────────────┘""");
    }
// director login and menu are separate flows to demonstrate role-based access and more complex interactions.
    private static void directorLogin() {
    System.out.print("Enter Director password: ");
    String input = scanner.nextLine();

    if (director.login(input)) {
        System.out.println("✅ Access granted!");
        directorMenu();
    } else {
        System.out.println("❌ Wrong password!");
    }
}
// The director menu allows managing the entire school, including viewing and removing students/teachers, and viewing all grades.
private static void directorMenu() {
    int choice;

    do {
        System.out.println("""
                
                ─── DIRECTOR PANEL ───
                1) View all students
                2) View all teachers
                3) Remove student
                4) Remove teacher
                5) View ALL grades
                0) Logout
                """);

        choice = readInt("→ Choice: ");

        switch (choice) {
            case 1 -> listAllStudents();
            case 2 -> listAllTeachers();
            case 3 -> removeStudent();
            case 4 -> removeTeacher();
            case 5 -> showAllGrades();
            case 0 -> System.out.println("Logging out...");
            default -> System.out.println("Invalid option!");
        }

    } while (choice != 0);
}
// delete studeent 
private static void removeStudent() {
    if (allStudents.isEmpty()) {
        System.out.println("No students to remove.");
        return;
    }

    listAllStudents();
    int index = readIntInRange("Select student to remove: ", 1, allStudents.size()) - 1;

    Student removed = allStudents.remove(index);
    System.out.println("Removed student: " + removed.getName());
}
// delete teacher
private static void removeTeacher() {
    if (allTeachers.isEmpty()) {
        System.out.println("No teachers to remove.");
        return;
    }

    listAllTeachers();
    int index = readIntInRange("Select teacher to remove: ", 1, allTeachers.size()) - 1;

    Teacher removed = allTeachers.remove(index);
    System.out.println("Removed teacher: " + removed.getName());
}

// Show all grades for all students in the system, regardless of teacher. This demonstrates aggregation and access to student data from a central point.
private static void showAllGrades() {
    if (allStudents.isEmpty()) {
        System.out.println("No students available.");
        return;
    }

    for (Student s : allStudents) {
        s.printGrades();
    }
}
// The following methods handle the flows for adding students/teachers, listing them, enrolling, grading, and showcasing features.
    // add scientific student
    private static void addScientificStudent() {
        System.out.println("\n─── Add Scientific Student ───");
        String name   = readNonBlankString("  Full name          : ");
        int    age    = readIntInRange("  Age               : ", 5, 25);
        String clazz  = readNonBlankString("  Class (e.g. 3B)    : ");
        String spec   = readNonBlankString("  Science spec.      : ");

        
        ScientificStudent s = new ScientificStudent(name, age, clazz, spec);
        allStudents.add(s);
        System.out.println("✅  Scientific student '" + name + "' created.");
        s.registration();    // demonstrate Registrable interface immediately
    }

    // add humanities student
    private static void addHumanitiesStudent() {
        System.out.println("\n─── Add Humanities Student ───");
        String name     = readNonBlankString("  Full name          : ");
        int    age      = readIntInRange("  Age               : ", 5, 25);
        String clazz    = readNonBlankString("  Class (e.g. 4A)    : ");
        String interest = readNonBlankString("  Arts interest      : ");

        HumanitiesStudent s = new HumanitiesStudent(name, age, clazz, interest);
        allStudents.add(s);
        System.out.println("✅  Humanities student '" + name + "' created.");
        s.registration();
    }

   // add STEM teacher
    private static void addSTEMTeacher() {
        System.out.println("\n─── Add STEM Teacher ───");
        String name     = readNonBlankString("  Full name          : ");
        int    age      = readIntInRange("  Age               : ", 21, 70);
        String subject  = readNonBlankString("  Subject            : ");
        String research = readNonBlankString("  Research field     : ");

        STEMTeacher t = new STEMTeacher(name, age, subject, research);
        allTeachers.add(t);
        System.out.println("✅  STEM teacher '" + name + "' created.");
        t.registration();
    }

   // add arts teacher
    private static void addArtsTeacher() {
        System.out.println("\n─── Add Arts Teacher ───");
        String name    = readNonBlankString("  Full name          : ");
        int    age     = readIntInRange("  Age               : ", 21, 70);
        String subject = readNonBlankString("  Subject            : ");
        String style   = readNonBlankString("  Teaching style     : ");

        ArtsTeacher t = new ArtsTeacher(name, age, subject, style);
        allTeachers.add(t);
        System.out.println("✅  Arts teacher '" + name + "' created.");
        t.registration();
    }

    // list all students in the system with their details. This is a simple read operation that demonstrates access to the student collection.
    private static void listAllStudents() {
        System.out.println("\n─── All Students ───");
        if (allStudents.isEmpty()) {
            System.out.println("  No students yet. Add some first!");
            return;
        }
        for (int i = 0; i < allStudents.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + allStudents.get(i));
        }
    }

    /** Prints a numbered list of all teachers currently in the system. */
    private static void listAllTeachers() {
        System.out.println("\n─── All Teachers ───");
        if (allTeachers.isEmpty()) {
            System.out.println("  No teachers yet. Add some first!");
            return;
        }
        for (int i = 0; i < allTeachers.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + allTeachers.get(i));
        }
    }
    // The following methods handle the flows for enrolling students with teachers, assigning grades, and showcasing polymorphism and registration features.
    private static void enrollStudentWithTeacher() {
        System.out.println("\n─── Enroll Student with Teacher ───");

        Teacher teacher = pickTeacher();
        if (teacher == null) return;

        Student student = pickStudent();
        if (student == null) return;

        teacher.enrollStudent(student);   
    }
    // The assignGradeFlow method demonstrates the process of a teacher assigning a grade to a student, enforcing the ownership rule that teachers can only grade their own students. It also includes input validation and user prompts to guide the flow.
    private static void assignGradeFlow() {
        System.out.println("\n─── Assign Grade ───");

        Teacher teacher = pickTeacher();
        if (teacher == null) return;

        // Show only the students belonging to this teacher
        List<Student> roster = teacher.getClassRoster();
        if (roster.isEmpty()) {
            System.out.println("⚠️  " + teacher.getName()
                    + " has no students enrolled yet. Use option 7 first.");
            return;
        }

        System.out.println("  Students in " + teacher.getName() + "'s class:");
        for (int i = 0; i < roster.size(); i++) {
            System.out.println("    " + (i + 1) + ". " + roster.get(i));
        }

        int sIdx = readIntInRange("  Pick student number: ", 1, roster.size()) - 1;
        Student student = roster.get(sIdx);

        int grade = readIntInRange("  Grade (0–10): ", 0, 10);
        teacher.assignGrade(student, grade);   // Teacher enforces ownership rule
    }

    
    private static void printStudentGradesFlow() {
        System.out.println("\n─── Student Grade Report ───");
        Student student = pickStudent();
        if (student == null) return;
        student.printGrades();   // Student handles its own grade display
    }

 
    private static void showcasePolymorphism() {
        System.out.println("\n─── Polymorphism Showcase: describeRole() ───");
        System.out.println("  Calling describeRole() on every Persona in the school:\n");

        // Merge into a single Persona list to emphasise polymorphism
        List<Persona> everyone = new ArrayList<>();
        everyone.addAll(allStudents);
        everyone.addAll(allTeachers);

        if (everyone.isEmpty()) {
            System.out.println("  School is empty. Add students or teachers first.");
            return;
        }

        for (Persona p : everyone) {
            System.out.print("  [" + p.getName() + "] → ");
            p.describeRole();   // ← same method call, different output each time
        }
    }


    private static void showcaseRegistration() {
        System.out.println("\n─── Registration Showcase: Registrable interface ───");

        List<Registrable> registrables = new ArrayList<>();
        registrables.addAll(allStudents);
        registrables.addAll(allTeachers);

        if (registrables.isEmpty()) {
            System.out.println("  School is empty. Add people first.");
            return;
        }

        for (Registrable r : registrables) {
            r.registration();    // interface polymorphism
        }
    }

    // Helper methods for picking teachers/students and reading input with validation.
    private static Teacher pickTeacher() {
        if (allTeachers.isEmpty()) {
            System.out.println("⚠️  No teachers in the system yet. Add one first.");
            return null;
        }
        listAllTeachers();
        int idx = readIntInRange("  Pick teacher number: ", 1, allTeachers.size()) - 1;
        return allTeachers.get(idx);
    }


    private static Student pickStudent() {
        if (allStudents.isEmpty()) {
            System.out.println("⚠️  No students in the system yet. Add one first.");
            return null;
        }
        listAllStudents();
        int idx = readIntInRange("  Pick student number: ", 1, allStudents.size()) - 1;
        return allStudents.get(idx);
    }

    // Reads an integer from the user, re-prompting until a valid integer is entered.
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine();  // consume leftover newline
                return value;
            } catch (InputMismatchException e) {
                scanner.nextLine();  // discard bad input
                System.out.println("  ⚠️  Please enter a whole number.");
            }
        }
    }

    // Reads an integer within a specified range from the user, re-prompting until valid input is given.
    private static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int v = readInt(prompt);
            if (v >= min && v <= max) return v;
            System.out.println("  ⚠️  Please enter a value between " + min + " and " + max + ".");
        }
    }

    // Reads a non-blank string from the user, re-prompting until valid input is given.
    private static String readNonBlankString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isBlank()) return input;
            System.out.println("  ⚠️  This field cannot be empty.");
        }
    }

// Preloads some demo teachers and students to allow immediate testing of features without manual data entry.
    private static void preloadDemoData() {
        // ── Teachers ──────────────────────────────────────────────────────────
        STEMTeacher  drNova    = new STEMTeacher ("Dr. Elena Nova",   45, "Physics",    "Quantum Entanglement");
        ArtsTeacher  mrBronte  = new ArtsTeacher ("Mr. James Brontë", 52, "Literature", "Socratic");
        allTeachers.add(drNova);
        allTeachers.add(mrBronte);

        // ── Students ──────────────────────────────────────────────────────────
        ScientificStudent alice = new ScientificStudent("Alice Fermi",   17, "5A", "Biology");
        ScientificStudent bob   = new ScientificStudent("Bob Heisenberg",16, "4B", "Physics");
        HumanitiesStudent cara  = new HumanitiesStudent("Cara Austen",   17, "5A", "Literature");
        HumanitiesStudent dan   = new HumanitiesStudent("Dan Umberto",   16, "4A", "History");
        
        allStudents.add(alice);
        allStudents.add(bob);
        allStudents.add(cara);
        allStudents.add(dan);

        // ── Enrol students in their matching teachers ─────────────────────────
        drNova.enrollStudent(alice);
        drNova.enrollStudent(bob);
        mrBronte.enrollStudent(cara);
        mrBronte.enrollStudent(dan);

        // ── Pre-assign some grades ────────────────────────────────────────────
        drNova.assignGrade(alice, 9);
        drNova.assignGrade(alice, 8);
        drNova.assignGrade(bob,   7);
        mrBronte.assignGrade(cara, 10);
        mrBronte.assignGrade(cara, 9);
        mrBronte.assignGrade(dan,  6);

        System.out.println("✅  Demo data loaded. 2 teachers & 4 students ready.\n");
    }
}