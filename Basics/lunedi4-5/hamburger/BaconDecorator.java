
public class BaconDecorator implements Hamburger {
    private Hamburger hamburger;

    public BaconDecorator(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    @Override
    public String getDescription() {
        return hamburger.getDescription() + ", Bacon";
    }

    @Override
    public Double getPrice() {
        return hamburger.getPrice() + 0.8;
    }
    
}
