package esame1AziendaManifattuturiera;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class Quality extends Thread{
    private Overall overall = null;
    private PipedInputStream pis = null;
    private AtomicBoolean running = new AtomicBoolean(false);

    public Quality(Overall overall, PipedInputStream pis) {
        this.overall = overall;
        this.pis = pis;
    }

    public void termina(){
        running.set(false);
    }

    public void run(){
        running.set(true);
        try {
            ObjectInputStream ois = new ObjectInputStream(pis);
            while (running.get()) {
                Message m = (Message) ois.readObject();
                if (m.getValore() < 0) {
                    overall.incrementaDifetti();
                }
                else {
                    overall.incrementaCorretti();
                }
                System.out.println(m.getMessaggio());

            }
        } catch (IOException | ClassNotFoundException e) {}
    }
}