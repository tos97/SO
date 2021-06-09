package activityManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;

public class Manager extends Thread{
    private PipedInputStream pis = null;
    private Monitor monitor = null;
    private Sorter sorter = null;

    public Manager(Monitor monitor,Sorter sorter,PipedInputStream pis){
        this.pis = pis;
        this.monitor = monitor;
        this.sorter = sorter;
    }

    public void run(){
        BufferedReader br = new BufferedReader(new InputStreamReader(pis));
        for (int i = 0;i < 10; i++){
            try{
                String line = br.readLine();
                System.out.println(line);
            }catch (IOException e){ }
        }
        monitor.setRunning(false);
        sorter.setRunning(false);
    }
}
