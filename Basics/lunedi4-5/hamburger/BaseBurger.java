public class BaseBurger implements Hamburger {
    Hamburger hamburger;


    public BaseBurger() {
        

    }
    @Override
    public String getDescription() {
        return "Hamburger base";
    }

    @Override
    public Double getPrice() {
        return 5.0;
    }
    
}
