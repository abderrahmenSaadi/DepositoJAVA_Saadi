
class Student {
    private String name;
    private int grade;
    private int id;
    private static int counter = 1;

    // Constructor
    public Student(String name, int grade) {
        this.name = name;
        this.id = counter++;
        setGrade(grade); // use setter for validation
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for grade
    public int getGrade() {
        return grade;
    }

    // Getter for ID (optional but useful)
    public int getId() {
        return id;
    }

    // Setter with validation
    public void setGrade(int grade) {
        if (grade >= 0 && grade <= 10) {
            this.grade = grade;
        } else {
            System.out.println("Error: grade must be between 0 and 10.");
        }
    }

    // toString for easy printing
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Grade: " + grade;
    }
}
