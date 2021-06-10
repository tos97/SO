package industria4;

public class Produzione {
    private int prodotti;
    private int latenza;
    private int corretto;

    public Produzione(){
        this.prodotti = 0;
        latenza = 0;
        corretto = 0;
    }

    public synchronized boolean incrementoProdotti(){
        if(Latenza.interruzione())
            latenza++;
        else{
            corretto++;
        }
        int n = prodotti;
        prodotti++;
        if (n != prodotti)
            return true;
        return false;
    }

    public void stampa(){
        System.out.println("Prodotti creati: "+prodotti);
        System.out.println("Latenze: "+latenza);
        System.out.println("Corretti: "+corretto);
    }
}
