
public abstract class Persona {

    private String name;
    private int    age;


    public Persona(String name, int age) {
        this.name = name;
        this.age  = age;
    }


    public String getName() { return name; }

    /** Returns the person's age. */
    public int getAge()     { return age; }

 
    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be empty.");
        this.name = name;
    }


    public void setAge(int age) {
        if (age < 1 || age > 120)
            throw new IllegalArgumentException("Age must be between 1 and 120.");
        this.age = age;
    }

    public abstract void describeRole();

    @Override
    public String toString() {
        return name + " (age " + age + ")";
    }
}