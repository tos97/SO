package industria4;

import java.util.Random;

public class Latenza {
    public static boolean interruzione(){
        try {
            if(new Random().nextInt(4) == 0){
                Thread.sleep(200);
                return true;
            } else {
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
