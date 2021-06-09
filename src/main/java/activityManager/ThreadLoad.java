package activityManager;

import java.util.HashMap;
import java.util.Map;

public class ThreadLoad{
    private Map<Integer, Double> treadLoad = null;

    public ThreadLoad() {
        this.treadLoad = new HashMap<>();
    }

    public synchronized int getMaxkey() {
        int id = 0;
        double cpu = 0;

        for (int element: treadLoad.keySet()){
            if(treadLoad.get(element) > cpu){
                cpu = treadLoad.get(element);
                id = element;
            }

        }

        return id;
    }

    public synchronized double getValues(int id){
        return treadLoad.get(id);
    }

    public synchronized void setTreadLoad(int id, double cpu) {
        this.treadLoad.put(id,cpu);
    }
}
