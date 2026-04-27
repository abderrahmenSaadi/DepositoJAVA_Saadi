/**
 * Class ScientificStudent - a student enrolled in a scientific track.
 * Extends Student and adds a specialisation field.
 * Demonstrates: multi-level INHERITANCE (ScientificStudent → Student → Persona).
 */
public class ScientificStudent extends Student {

    // ── Private field specific to this subclass ────────────────────────────────
    private String scienceSpecialisation; // e.g. "Biology", "Physics"


    public ScientificStudent(String name, int age,
                             String attendedClass, String scienceSpecialisation) {
        super(name, age, attendedClass);   // call Student constructor
        this.scienceSpecialisation = scienceSpecialisation;
    }

    // ── Getter / Setter ────────────────────────────────────────────────────────

    /** Returns the science specialisation. */
    public String getScienceSpecialisation() { return scienceSpecialisation; }


    public void setScienceSpecialisation(String spec) {
        if (spec == null || spec.isBlank())
            throw new IllegalArgumentException("Specialisation cannot be empty.");
        this.scienceSpecialisation = spec;
    }

    // ── Override ───────────────────────────────────────────────────────────────

    /**
     * Provides a richer role description that includes the science specialisation.
     * Demonstrates POLYMORPHISM: calling describeRole() on a Persona reference
     * triggers THIS method when the object is a ScientificStudent.
     */
    @Override
    public void describeRole() {
        System.out.println("I am a student of class " + getAttendedClass()
                + " – Scientific track: " + scienceSpecialisation + " 🔬");
    }

    /** Readable label used in menus. */
    @Override
    public String toString() {
        return super.toString() + " [Sci: " + scienceSpecialisation + "]";
    }
}



