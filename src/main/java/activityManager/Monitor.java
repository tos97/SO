package activityManager;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Monitor implements Runnable{
    private ThreadLoad threadLoad = null;
    private AtomicBoolean running = new AtomicBoolean(false);

    public Monitor(ThreadLoad threadLoad){
        this.threadLoad = threadLoad;
    }

    public void setRunning(boolean fine){
        running.set(fine);
    }

    public void run(){
        running.set(true);
        while(running.get()){
            try{
                int id = new Random().nextInt(9) + 1;
                double cpu = (new Random().nextDouble()) * 100;
                threadLoad.setTreadLoad(id,cpu);
                Thread.sleep(200);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
