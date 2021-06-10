package industria4;

public class Run {
    public static void main(String [] argv){
        int nMacchine = 10;
        Produzione produzione = new Produzione();

        Macchina [] macchine = new Macchina[nMacchine];
        for (int i = 0;i < nMacchine;i++){
            macchine[i] = new Macchina(produzione);
            macchine[i].start();
        }

        for (int i = 0;i < nMacchine;i++){
            try {
                macchine[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        produzione.stampa();
    }
}
