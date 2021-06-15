package meteo;

import esame1AziendaManifattuturiera.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PipedOutputStream;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class GeneraDati implements Runnable{
    private AtomicBoolean running = new AtomicBoolean(false);
    private PipedOutputStream pos;

    public GeneraDati(PipedOutputStream pos) {
        this.pos = pos;
    }

    public void finisci(){
        running.set(false);
    }

    @Override
    public void run() {
        running.set(true);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(pos);
            while (running.get()) {
                Thread.sleep(2500);
                float temperatura = new Random().nextFloat() * 30 - 5;
                int umidita = new Random().nextInt(71) + 15;
                Misure m = new Misure(umidita,temperatura);
                oos.writeObject(m);
                oos.flush();
            }
        } catch (InterruptedException | IOException e){}
    }
}
