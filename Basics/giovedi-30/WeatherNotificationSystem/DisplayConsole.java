public class DisplayConsole implements Display {

    @Override
    public void aggiorna(float temperatura) {
        System.out.println("Display Console - Temperatura aggiornata: " + temperatura + "°C");
    }
}