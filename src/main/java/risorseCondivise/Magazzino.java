package risorseCondivise;

import java.util.HashMap;
import java.util.Map;

public class Magazzino {
    Map<String,Integer> magazzino = null;

    public Magazzino() {
        this.magazzino = new HashMap<>();
    }

    public synchronized boolean existObject(String nome){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) { }

        return magazzino.containsKey(nome);
    }

    public synchronized void addObject(String nome, int id){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) { }

        if(!magazzino.containsKey(nome)) {
            System.out.println("Creo oggetto bulloni" +" Thread "+id);
            magazzino.put(nome, new Integer(0));
        }
    }

    public synchronized boolean quantity(String nome, int q){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) { }

        if (magazzino.containsKey(nome)) {
            if ((magazzino.get(nome) + q) > 0) {
                magazzino.put(nome, new Integer(magazzino.get(nome) + q));
                return true;
            }
            else {
                System.out.print("Errore di quantità");
                return false;
            }
        }
        else{
            System.out.println(nome + " non esiste in magazzino");
            return false;
        }
    }


    public synchronized String toString(){
        String result = "";
        for (String object: magazzino.keySet()){
            result += object + ": " + magazzino.get(object);
        }
        return result;
    }
}
