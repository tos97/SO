package industria4;

import java.util.Random;

public class Macchina extends Thread{
    private Produzione produzione = null;

    public Macchina(Produzione produzione){
        this.produzione = produzione;
    }

    public void run(){
        try {
            System.out.println(Thread.currentThread() + " creato");
            int n = 0;
            for (int i = 0;i < 35;i++){
                if(produzione.incrementoProdotti())
                    n++;
                Thread.sleep((500 + new Random().nextInt(100)));
            }
            if (n == 35)
                System.out.println("Il "+Thread.currentThread() + " ha creato i 35 prodotti richiesti");
            else{
                System.out.println("Il "+Thread.currentThread() + " ha fallito");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
