public class Main {
    public static void main(String[] args) {

        StazioneMeteo stazione = new StazioneMeteo();

        Display console = new DisplayConsole();
        Display mobile = new DisplayMobile();

        stazione.aggiungiDisplay(console);
        stazione.aggiungiDisplay(mobile);

        System.out.println("Prima variazione:");
        stazione.setTemperatura(25.5f);

        System.out.println("\nSeconda variazione:");
        stazione.setTemperatura(30.0f);

        // Rimuovo un display
        stazione.rimuoviDisplay(console);

        System.out.println("\nTerza variazione (solo mobile):");
        stazione.setTemperatura(18.3f);
    }
}