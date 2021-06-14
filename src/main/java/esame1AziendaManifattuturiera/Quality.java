package esame1AziendaManifattuturiera;

import java.io.PipedInputStream;

public class Quality extends Thread{
    Overall overall = null;
    PipedInputStream pis = null;

    public Quality(Overall overall, PipedInputStream pis) {
        this.overall = overall;
        this.pis = pis;
    }
}
