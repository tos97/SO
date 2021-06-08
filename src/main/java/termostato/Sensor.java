package termostato;

import com.sun.corba.se.pept.encoding.OutputObject;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PipedOutputStream;
import java.util.Random;

public class Sensor extends Thread{
    Random rand = new Random();
    PipedOutputStream pos = null;
    ObjectOutputStream oos = null;

    public Sensor(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            oos = new ObjectOutputStream(pos);
            while(true){
                try {
                    Thread.sleep(2000);
                }catch(InterruptedException e){ }


                    float temperatura = 18 + rand.nextFloat() * (21-18);
                    Message mes = new Message(temperatura);
                    oos.writeObject(mes);
                    oos.flush();

            }
        } catch (IOException e){

        }
    }
}
