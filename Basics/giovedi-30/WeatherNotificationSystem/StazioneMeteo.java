import java.util.ArrayList;
import java.util.List;

public class StazioneMeteo {

    private List<Display> displays;
    private float temperatura;

    public StazioneMeteo() {
        displays = new ArrayList<>();
    }

    public void aggiungiDisplay(Display d) {
        displays.add(d);
    }

    public void rimuoviDisplay(Display d) {
        displays.remove(d);
    }

    public void notificaDisplay() {
        for (Display d : displays) {
            d.aggiorna(temperatura);
        }
    }

    public void setTemperatura(float t) {
        this.temperatura = t;
        notificaDisplay();
    }
}