public class Animal {
    protected String name;
    protected String sound;
    protected int hp;
    protected int attack;
    protected double attackSpeed;

    public Animal(String name, String sound, int hp, int attack, double attackSpeed) {
        this.name = name;
        this.sound = sound;
        this.hp = hp;
        this.attack = attack;
        this.attackSpeed = attackSpeed;
    }

    public void makeSound() {
        System.out.println(sound);
    }

    public void showStats() {
        System.out.println("Name: " + name);
        System.out.println("HP: " + hp);
        System.out.println("Attack: " + attack);
        System.out.println("Attack Speed: " + attackSpeed);
    }
}