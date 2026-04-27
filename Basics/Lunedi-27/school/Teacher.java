import java.util.ArrayList;
import java.util.List;

public class Teacher extends Persona implements Registrable {

    private String        subject;       // the subject this teacher teaches
    private List<Student> classRoster;  // students assigned to this teacher ONLY


    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject     = subject;
        this.classRoster = new ArrayList<>();
    }



    /** Returns the subject this teacher teaches. */
    public String getSubject() { return subject; }


    public void setSubject(String subject) {
        if (subject == null || subject.isBlank())
            throw new IllegalArgumentException("Subject cannot be empty.");
        this.subject = subject;
    }

    public List<Student> getClassRoster() { return new ArrayList<>(classRoster); }


    public void enrollStudent(Student student) {
        if (classRoster.contains(student)) {
            System.out.println("⚠️  " + student.getName()
                    + " is already in " + getName() + "'s roster.");
            return;
        }
        classRoster.add(student);
        System.out.println("✅  " + student.getName()
                + " enrolled in " + getName() + "'s " + subject + " class.");
    }

    public void assignGrade(Student student, int grade) {
        if (!classRoster.contains(student)) {
            System.out.println("❌  " + getName()
                    + " cannot grade " + student.getName()
                    + " – not in this teacher's roster.");
            return;
        }
        student.addGrade(grade);          // delegate to Student (encapsulation)
        System.out.println("📝  " + getName() + " assigned grade " + grade
                + "/10 to " + student.getName() + " in " + subject + ".");
    }

    /**
     * Prints the full class roster for this teacher.
     */
    public void printRoster() {
        System.out.println("\n👩‍🏫  " + getName() + "'s " + subject + " class roster:");
        if (classRoster.isEmpty()) {
            System.out.println("   No students enrolled yet.");
            return;
        }
        for (int i = 0; i < classRoster.size(); i++) {
            System.out.println("   " + (i + 1) + ". " + classRoster.get(i));
        }
    }


    @Override
    public void describeRole() {
        System.out.println("I am a teacher of " + subject + ".");
    }

   
    @Override
    public void registration() {
        System.out.println("Registration via academic secretary (teacher: " + getName() + ").");
    }

    @Override
    public String toString() {
        return super.toString() + " | Subject: " + subject;
    }
}