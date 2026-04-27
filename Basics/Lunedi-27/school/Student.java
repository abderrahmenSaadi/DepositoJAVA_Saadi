import java.util.ArrayList;
import java.util.List;

public class Student extends Persona implements Registrable {

    // ── Private fields ─────────────────────────────────────────────────────────
    private String       attendedClass;        // e.g. "3B", "5A"
    private List<Integer> grades;              // grades received from teachers


    public Student(String name, int age, String attendedClass) {
        super(name, age);                      // call parent constructor (Persona)
        this.attendedClass = attendedClass;
        this.grades        = new ArrayList<>();
    }

    // ── Getters / Setters ──────────────────────────────────────────────────────

    /** Returns the class/section this student attends. */
    public String getAttendedClass() { return attendedClass; }

    public void setAttendedClass(String attendedClass) {
        if (attendedClass == null || attendedClass.isBlank())
            throw new IllegalArgumentException("Attended class cannot be empty.");
        this.attendedClass = attendedClass;
    }

    /** Returns a defensive copy of the grade list so callers cannot mutate it directly. */
    public List<Integer> getGrades() { return new ArrayList<>(grades); }


    public void addGrade(int grade) {
        if (grade < 0 || grade > 10)
            throw new IllegalArgumentException("Grade must be between 0 and 10.");
        grades.add(grade);
    }

    /**
     * Prints all grades this student has received.
     * If no grades exist yet a friendly message is shown.
     */
public void printGrades() {
    System.out.println("\n📋  Grades for " + getName() + " [" + attendedClass + "]");

    if (grades.isEmpty()) {
        System.out.println("   No grades recorded yet.");
        return;
    }

    // Calculate average using a classic loop
    int sum = 0;
    for (int grade : grades) {
        sum += grade;
    }

    double avg = (double) sum / grades.size();

    System.out.println("   Grades : " + grades);
    System.out.printf("   Average: %.2f%n", avg);

    // Creative touch: emoji rating based on average
    System.out.println("   Rating : " + performanceEmoji(avg));
}

    /** Returns a fun emoji badge based on average grade. */
    private String performanceEmoji(double avg) {
        if (avg >= 9) return " Outstanding!";
        if (avg >= 7) return " Good job!";
        if (avg >= 5) return "Keep studying!";
        return "  Needs improvement";
    }

    @Override
    public void describeRole() {
        System.out.println("I am a student of class " + attendedClass + ".");
    }

    @Override
    public void registration() {
        System.out.println("Registration via online form (student: " + getName() + ").");
    }

    @Override
    public String toString() {
        return super.toString() + " | Class: " + attendedClass;
    }
}