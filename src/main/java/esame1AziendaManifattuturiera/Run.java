package esame1AziendaManifattuturiera;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Run {
    public static void main(String [] argv){
        Overall overall = new Overall();

        PipedInputStream pis = new PipedInputStream();
        try {
            PipedOutputStream pos = new PipedOutputStream(pis);
            Macchine macchine = new Macchine(pos);
            Quality quality = new Quality(overall,pis);
            macchine.start();
            quality.start();

            while (true){
                Thread.sleep(1000);
                System.out.println("Prodotti buoni: "+overall.getCorretti());
                System.out.println("Prodotti difettosi: "+overall.getDifetti());
                if (overall.getDifetti() > overall.getCorretti())
                    break;
            }
            System.out.println("terminazione Macchine");
            macchine.termina();
            quality.termina();
            macchine.join();
            quality.join();
        }  catch (IOException | InterruptedException e) {
        }
    }
}