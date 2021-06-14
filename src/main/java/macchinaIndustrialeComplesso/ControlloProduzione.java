package macchinaIndustrialeComplesso;

public class ControlloProduzione {
    private int prodottiTerminati;
    private int prodottiParziali;

    public ControlloProduzione(){
        prodottiParziali = 0;
        prodottiTerminati = 0;
    }

    public synchronized void setProdottiTerminati(){
        int tmp = prodottiTerminati;
        tmp++;
        prodottiTerminati = tmp;
    }

    public synchronized void increaseProdottiParziali(){
        int tmp = prodottiParziali;
        tmp++;
        prodottiParziali = tmp;
    }

    public synchronized void decreaseProdottiParziali(){
        int tmp = prodottiParziali;
        tmp--;
        prodottiParziali = tmp;
    }

    public synchronized int getProdottiTerminati() {
        return prodottiTerminati;
    }

    public synchronized int getProdottiParziali() {
        return prodottiParziali;
    }
}
