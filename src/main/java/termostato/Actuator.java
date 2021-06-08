package termostato;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;

public class Actuator extends Thread{
    private float temperatura;
    PipedInputStream pis = null;
    ObjectInputStream ois = null;

    public Actuator(PipedInputStream pis, float temp){
        this.pis = pis;
        this.temperatura = temp;
    }

    public void run(){
        try{
            ois = new ObjectInputStream(pis);
            while (true) {
                Message mes = (Message) ois.readObject();
                System.out.print("temp: "+ mes.getMessage());
                if (temperatura > mes.getMessage()) {
                    System.out.println(" Termosifoni accesi");
                } else {
                    System.out.println(" termosifoni Spenti");
                }
            }
        }catch (IOException | ClassNotFoundException e){

        }
    }
}
