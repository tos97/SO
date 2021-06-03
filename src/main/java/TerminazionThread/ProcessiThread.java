package TerminazionThread;

import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessiThread implements Runnable{

    private Thread t = null;
    private int Id;
    private final AtomicBoolean running = new AtomicBoolean(false);

    public ProcessiThread(int numero) {
        this.Id = numero;
    }

    public void start(){
        this.t = new Thread(this);
        t.start();
    }

    public void stop(){
        running.set(false);
    }

    @Override
    public void run() {
        running.set(true);
        while (running.get()){
            try {
                System.out.println("Thread: " + Id);
                Thread.sleep(5000);
            } catch (InterruptedException e){
                System.out.println("Eleminazione T: "+Id);
                Thread.currentThread().interrupt();
            }
        }
    }
}
