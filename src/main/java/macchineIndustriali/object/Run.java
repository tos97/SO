package macchineIndustriali.object;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Run {
    public static void main(String [] argv) throws InterruptedException{
        PipedInputStream pis = new PipedInputStream();
        try{
            PipedOutputStream pos = new PipedOutputStream(pis);
            MacchinaA mA = new MacchinaA(pos);
            MacchinaB mB = new MacchinaB(pis);
            mA.start();
            mB.start();
            Thread.sleep(10000);
            mA.termina();
            mB.termina();
            mA.join();
            mB.join();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
