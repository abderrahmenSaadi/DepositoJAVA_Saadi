public class Cat extends Animal {

    public Cat(String name, int hp, int attack, double attackSpeed) {
        super(name, "Meow!", hp, attack, attackSpeed);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}