package macchineIndustriali.object;

import macchineIndustriali.object.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class MacchinaB extends Thread{
    private PipedInputStream pis = null;
    private AtomicBoolean running = new AtomicBoolean(false);

    public MacchinaB(PipedInputStream pis){
        this.pis = pis;
    }

    public void termina(){
        System.out.println("terminazione macchinaB");
        running.set(false);
        //Thread.currentThread().interrupt();
    }

    public void run(){
        running.set(true);
        try {
            int i = 1;
            ObjectInputStream ois = new ObjectInputStream(pis);
            while(true){
                Message m = (Message) ois.readObject();
                if (m.getMessage().length() > 0) {
                    System.out.println("Messaggio ricevuto partenza parte 2 del processo " + i);
                    i++;
                }
                Thread.sleep(200);
                if (!running.get())
                    Thread.currentThread().interrupt();
            }
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
