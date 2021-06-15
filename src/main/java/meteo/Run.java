package meteo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Run {
    public static void main(String [] argv){

        int [] temp = {0,0};
        boolean fine = false;
        Storico storico = new Storico();

        PipedInputStream pis = new PipedInputStream();
        try {
            PipedOutputStream pos = new PipedOutputStream(pis);
            GeneraDati generaDati = new GeneraDati(pos);
            Thread tgeneraDati = new Thread(generaDati);
            tgeneraDati.start();

            Avvisi avvisi = new Avvisi(storico);
            avvisi.start();

            ObjectInputStream ois = new ObjectInputStream(pis);
            while(!fine) {
                Misure m = (Misure) ois.readObject();
                //System.out.println(m.getTemperatura() + ", " + m.getUmidita());
                temp[1] = m.getUmidita();
                if (temp[0] != 0) {
                    if (((temp[0] * 2) / 10) < Math.abs(temp[1] - temp[0])) {
                        storico.incrementaCambiRepentini();
                        if (((temp[0] * 4) / 10) < (temp[1] - temp[0])){
                            System.out.println("Terminazione Programma");
                            avvisi.finisci();
                            avvisi.join();
                            generaDati.finisci();
                            tgeneraDati.join();
                            fine = true;
                        }
                    }
                }
                temp[0] = temp[1];
            }
        } catch (IOException | ClassNotFoundException | InterruptedException e) { }
    }
}
