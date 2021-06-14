package esame1AziendaManifattuturiera;

import java.io.Serializable;

public class Message implements Serializable {
    private String messaggio;
    private float valore;

    public Message(String messaggio,float valore){
        this.messaggio = messaggio;
        this.valore = valore;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public float getValore() {
        return valore;
    }
}