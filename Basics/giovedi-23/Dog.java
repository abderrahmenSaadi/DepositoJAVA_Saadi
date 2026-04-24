public class Dog extends Animal {

    public Dog(String name, int hp, int attack, double attackSpeed) {
        super(name, "Bark!", hp, attack, attackSpeed);
    }

    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }
}