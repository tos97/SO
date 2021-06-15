package meteo;

import java.io.Serializable;

public class Misure implements Serializable {
    private int umidita = 0;
    private float temperatura = 0;

    public Misure(int umidita, float temperatura) {
        this.umidita = umidita;
        this.temperatura = temperatura;
    }

    public int getUmidita() {
        return umidita;
    }

    public float getTemperatura() {
        return temperatura;
    }
}
