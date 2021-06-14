package macchineIndustriali.object;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class MacchinaA extends Thread{
    private PipedOutputStream pos = null;
    private AtomicBoolean running = new AtomicBoolean(false);

    public MacchinaA(PipedOutputStream pos){
        this.pos = pos;
    }

    public void termina(){
        System.out.println("terminazione macchinaA");
        running.set(false);
        //Thread.currentThread().interrupt();
    }

    public void run(){
        running.set(true);
        try {
            int i = 1;
            ObjectOutputStream oos = new ObjectOutputStream(pos);
            while (true){
                Thread.sleep(200);
                String messaggio = "Prima parte dell'operazioone fatta " + i;
                System.out.println(messaggio);
                Message m = new Message(messaggio);
                oos.writeObject(m);
                oos.flush();
                i++;
                if (!running.get())
                    Thread.currentThread().interrupt();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
