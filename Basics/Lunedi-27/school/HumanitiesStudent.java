class HumanitiesStudent extends Student {

    // ── Private field specific to this subclass ────────────────────────────────
    private String artsInterest; // e.g. "Literature", "History", "Philosophy"


    public HumanitiesStudent(String name, int age,String attendedClass, String artsInterest) {
        super( name, age, attendedClass);   // call Student constructor
        this.artsInterest = artsInterest;
    }
 
    // ── Getter / Setter ────────────────────────────────────────────────────────

    /** Returns the arts interest. */
    public String getArtsInterest() { return artsInterest; }


    public void setArtsInterest(String interest) {
        if (interest == null || interest.isBlank())
            throw new IllegalArgumentException("Arts interest cannot be empty.");
        this.artsInterest = interest;
    }

    // ── Override ───────────────────────────────────────────────────────────────

    /**
     * Role description specific to humanities students.
     * Again demonstrates POLYMORPHISM: same method name, different behaviour.
     */
    @Override
    public void describeRole() {
        System.out.println("I am a student of class " + getAttendedClass()
                + " – Humanities track: " + artsInterest + " 📜");
    }

    /** Readable label used in menus. */
    @Override
    public String toString() {
        return super.toString() + " [Hum: " + artsInterest + "]";
    }
}