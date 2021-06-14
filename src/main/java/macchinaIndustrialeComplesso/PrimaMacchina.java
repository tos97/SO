package macchinaIndustrialeComplesso;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class PrimaMacchina extends Thread{
    private ControlloProduzione cp = null;
    private AtomicBoolean running = new AtomicBoolean(false);

    public PrimaMacchina(ControlloProduzione cp){
        this.cp = cp;
    }

    public void termina(){
        running.set(false);
        System.out.println("terminazione MacchinaA");
    }

    public void run(){
        running.set(true);
        while (running.get()){
            try {
                Thread.sleep(new Random().nextInt(100)+400);
                if(running.get()) {
                    cp.increaseProdottiParziali();
                    System.out.println("creato lavoro parziale, ce ne sono: " + cp.getProdottiParziali());
                }
            } catch (InterruptedException e) {}
        }
    }
}
