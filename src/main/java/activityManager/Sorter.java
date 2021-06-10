package activityManager;

import java.io.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Sorter implements Runnable{
    private ThreadLoad threadLoad = null;
    private PipedOutputStream pos = null;
    private AtomicBoolean running = new AtomicBoolean(false);


    public Sorter(ThreadLoad threadLoad, PipedOutputStream pos){
        this.threadLoad = threadLoad;
        this.pos = pos;
    }

    public void setRunning(boolean fine){
        running.set(fine);
    }

    public void run(){
        running.set(true);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(pos));
        while(running.get()){
            try{
                Thread.sleep(150);
                int id = threadLoad.getMaxkey();
                if (id == 0)
                    continue;
                double cpu = threadLoad.getValues(id);
                String risultato = "IL Thread "+id+" ha la temperatura di "+cpu;
                bw.write(risultato);
                bw.newLine();
                bw.flush();
            }catch (InterruptedException | IOException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
