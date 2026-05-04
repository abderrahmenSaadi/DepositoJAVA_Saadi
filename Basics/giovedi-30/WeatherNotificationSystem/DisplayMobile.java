public class DisplayMobile implements Display {

    @Override
    public void aggiorna(float temperatura) {
        System.out.println("📱 Display Mobile -> Temp: " + temperatura + "°C");
    }
}