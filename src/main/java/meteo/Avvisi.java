package meteo;

import java.util.concurrent.atomic.AtomicBoolean;

public class Avvisi extends Thread{
    Storico storico = null;
    private AtomicBoolean running = new AtomicBoolean(false);

    public Avvisi(Storico storico){
        this.storico = storico;
    }

    public void finisci(){
        running.set(false);
    }

    public void run(){
        running.set(true);
        try{
            while(running.get()){
                Thread.sleep(2000);
                System.out.println("Attenzione! "+storico.getCambiRepentini());
            }
        } catch (InterruptedException e){}
    }
}
