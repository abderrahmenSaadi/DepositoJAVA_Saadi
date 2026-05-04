
public class Restau {
    public static void main(String[] args) {
        BaseBurger base = new BaseBurger();
        System.out.println(base.getDescription() + " - " + base.getPrice() + "€");

        Hamburger hamburgerWithChesse = new FormaggioDecorator(base);
        System.out.println(hamburgerWithChesse.getDescription() + " - " + hamburgerWithChesse.getPrice() + "euro");

        Hamburger hamburgerWithBacon = new BaconDecorator(base);
        System.out.println(hamburgerWithBacon.getDescription() + " - " + hamburgerWithBacon.getPrice() + "euro");
    }
    
}
