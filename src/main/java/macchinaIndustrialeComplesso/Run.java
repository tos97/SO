package macchinaIndustrialeComplesso;

import java.io.*;

public class Run {
    public static void main(String [] argv){
        ControlloProduzione cp = new ControlloProduzione();

        PrimaMacchina pm1 = new PrimaMacchina(cp);
        pm1.start();
        PrimaMacchina pm2 = new PrimaMacchina(cp);
        pm2.start();

        PipedInputStream pis = new PipedInputStream();
        try {
            PipedOutputStream pos = new PipedOutputStream(pis);
            SecondaMacchina sm = new SecondaMacchina(pos,cp);
            sm.start();
            ObjectInputStream ois = new ObjectInputStream(pis);
            for (int i = 0;i < 15;i++){
                Message m = (Message) ois.readObject();
                System.out.println(m.getMessage()+" "+(i+1));
            }
            pm1.termina();
            pm2.termina();
            sm.termina();
            pm1.join();
            pm2.join();
            sm.join();
            System.out.println("Prodotti Terminati: "+cp.getProdottiTerminati());
            System.out.println("prodotti Parziali: "+cp.getProdottiParziali());
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
