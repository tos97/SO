package termostato;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;

public class Run {
    public static void main(String[] argv){
        Float temp = (float) 0;
        do{
            try {
                System.out.print("inserisci a che valore attivare termosifoni: ");
                temp = new Scanner(System.in).nextFloat();
                if(temp > 18.0 && temp < 21.0)
                    break;
                else{
                    System.out.println("temperatura non valida per termostato");
                }
            } catch (Exception e){
                System.out.println("il valore non è valido");
            }
        } while(true);

        PipedInputStream pis = new PipedInputStream();

        try{
            PipedOutputStream pos = new PipedOutputStream(pis);
            Sensor sensore = new Sensor(pos);
            Actuator actuator = new Actuator(pis, temp);
            sensore.start();
            actuator.start();
        } catch (IOException e){

        }


    }
}
