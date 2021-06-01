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
        t = new Thread();
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
                Thread.sleep(100);
            } catch (InterruptedException e){
                stop();
                System.out.println("Eleminazione T: "+Id);
            }
        }
    }
}
