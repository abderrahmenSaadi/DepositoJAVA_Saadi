
public class STEMTeacher extends Teacher {

    // ── Private field specific to this subclass ────────────────────────────────
    private String researchField; // e.g. "Quantum Physics", "Combinatorics"


    public STEMTeacher(String name, int age, String subject, String researchField) {
        super(name, age, subject);   // call Teacher constructor
        this.researchField = researchField;
    }


    /** Returns the research field of this STEM teacher. */
    public String getResearchField() { return researchField; }

    public void setResearchField(String researchField) {
        if (researchField == null || researchField.isBlank())
            throw new IllegalArgumentException("Research field cannot be empty.");
        this.researchField = researchField;
    }



    @Override
    public void describeRole() {
        System.out.println("I am a STEM teacher of " + getSubject()
                + ", researching " + researchField + " 🔭");
    }

    /** Readable label used in menus. */
    @Override
    public String toString() {
        return super.toString() + " [Research: " + researchField + "]";
    }
}



