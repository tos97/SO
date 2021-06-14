package macchinaIndustrialeComplesso;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PipedOutputStream;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class SecondaMacchina extends Thread{
    private PipedOutputStream pos = null;
    private ControlloProduzione cp = null;
    private AtomicBoolean running = new AtomicBoolean(false);

    public SecondaMacchina(PipedOutputStream pos,ControlloProduzione cp){
        this.pos = pos;
        this.cp = cp;
    }

    public void termina(){
        running.set(false);
        System.out.println("terminazione MacchinaB");
    }

    public void run(){
        running.set(true);
        try {
        ObjectOutputStream oos = new ObjectOutputStream(pos);
        while (running.get()){
            while (cp.getProdottiParziali() < 1) {
                System.out.println("in attesa di prodotti parziali");
                Thread.sleep(2000);
            }
            cp.decreaseProdottiParziali();
            Thread.sleep(new Random().nextInt(50) + 100);
            cp.setProdottiTerminati();
            Message m = new Message("Prodotto Terminato");
            oos.writeObject(m);
            oos.flush();
        }
        } catch (InterruptedException | IOException e) {}
    }
}
