package esame1AziendaManifattuturiera;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PipedOutputStream;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Macchine extends Thread{
    private PipedOutputStream pos = null;
    private AtomicBoolean running = new AtomicBoolean(false);
    private int prodottiFiniti;
    private float valore;
    private String messaggio;

    public Macchine(PipedOutputStream pos) {
        this.pos = pos;
        prodottiFiniti = 0;
    }

    public void termina(){
        running.set(false);
    }

    public void run(){
        running.set(true);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(pos);
            while (running.get()) {
                prodottiFiniti++;
                valore = new Random().nextFloat() * 2000 - 1000;
                messaggio = "OK";
                if (valore < 0)
                    messaggio = "ERRORE " + prodottiFiniti;
                Message m = new Message(messaggio, valore);
                oos.writeObject(m);
                oos.flush();
                Thread.sleep(750);
            }
        } catch (InterruptedException | IOException e){ }
    }
}