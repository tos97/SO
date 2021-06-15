package meteo;

public class Storico {
    private int cambiRepentini = 0;

    public synchronized int getCambiRepentini() {
        return cambiRepentini;
    }

    public synchronized void incrementaCambiRepentini() {
        this.cambiRepentini++;
    }
}
