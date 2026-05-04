
public class FormaggioDecorator implements Hamburger {
    Hamburger hamburger;
    Double price;

    public FormaggioDecorator(Hamburger hamburger) {
        this.hamburger = hamburger;
       
    }

    @Override
    public String getDescription() {
        return hamburger.getDescription() + ", con formaggio";
    }

    @Override
    public Double getPrice() {
        return hamburger.getPrice() + 0.50;
    }
}
