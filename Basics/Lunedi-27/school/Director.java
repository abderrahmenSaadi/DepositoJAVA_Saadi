public class Director extends Persona implements Registrable {

    private String password;

    public Director(String name, int age, String password) {
        super(name, age);
        this.password = password;
    }

    // Simple authentication
    public boolean login(String inputPassword) {
        return password.equals(inputPassword);
    }

    @Override
    public void describeRole() {
        System.out.println("I am the school Director 👔");
    }

    @Override
    public void registration() {
        System.out.println("Director registered via administration system");
    }
}