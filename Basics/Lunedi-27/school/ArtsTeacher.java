class ArtsTeacher extends Teacher {

    // ── Private field specific to this subclass ────────────────────────────────
    private String teachingStyle; // e.g. "Socratic", "Project-based", "Lecture"


    public ArtsTeacher(String name, int age, String subject, String teachingStyle) {
        super(name, age, subject);
        this.teachingStyle = teachingStyle;
    }

    // ── Getter / Setter ────────────────────────────────────────────────────────

    /** Returns the teaching style of this arts teacher. */
    public String getTeachingStyle() { return teachingStyle; }

    public void setTeachingStyle(String style) {
        if (style == null || style.isBlank())
            throw new IllegalArgumentException("Teaching style cannot be empty.");
        this.teachingStyle = style;
    }

    // ── Override ───────────────────────────────────────────────────────────────

    /**
     * Role description specific to arts teachers.
     */
    @Override
    public void describeRole() {
        System.out.println("I am an Arts teacher of " + getSubject()
                + ", using a " + teachingStyle + " teaching style 🎭");
    }

    /** Readable label used in menus. */
    @Override
    public String toString() {
        return super.toString() + " [Style: " + teachingStyle + "]";
    }
}