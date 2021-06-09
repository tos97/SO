package activityManager;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Run {
    public static void main(String[] args) {
        ThreadLoad threadLoad = new ThreadLoad();

        Monitor monitor = new Monitor(threadLoad);
        Thread tmonitor = new Thread(monitor);

        PipedOutputStream pos = new PipedOutputStream();
        try{
            PipedInputStream pis = new PipedInputStream(pos);

            Sorter sorter = new Sorter(threadLoad, pos);
            Thread tsorter = new Thread(sorter);

            Manager manager = new Manager(monitor,sorter,pis);
            tmonitor.start();
            tsorter.start();
            manager.start();

        }catch (IOException e){
            System.out.println("Errore "+e.getMessage());
        }
    }
}
