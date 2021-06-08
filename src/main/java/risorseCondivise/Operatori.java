package risorseCondivise;

import java.util.concurrent.atomic.AtomicBoolean;

public class Operatori extends Thread{

    private Magazzino mag = null;
    private int id;

    public Operatori(int id, Magazzino m) {
        this.id = id;
        this.mag = m;
    }

    @Override
    public void run() {
        if (!mag.existObject("bulloni")){
            mag.addObject("bulloni");
            System.out.println("Creo oggetto bulloni" +" Thread "+id);
        }

        if (mag.quantity("bulloni", 1000))
            System.out.println("Operatore " + id + ": aggiungo 1000 pezzi di bulloni");
        else{
            System.out.println(" Thread "+id+ " somma");
        }

        if (mag.quantity("bulloni", -500))
            System.out.println("Operatore " + id + ": rimuovo 500 pezzi di bulloni");
        else{
            System.out.println(" Thread "+id+ " sottrazione");
        }
    }
}
