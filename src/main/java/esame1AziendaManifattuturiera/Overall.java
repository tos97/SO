package esame1AziendaManifattuturiera;

public class Overall {
    private int difettosi;
    private int buoni;

    public Overall(){
        difettosi = 0;
        buoni = 0;
    }

    public synchronized void incrementaDifetti(){
        difettosi++;
    }
    public synchronized void incrementaCorretti(){
        buoni++;
    }
    public synchronized int getDifetti(){
        return difettosi;
    }
    public synchronized int getCorretti(){
        return buoni;
    }
}