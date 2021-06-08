package risorseCondivise;

import java.util.Scanner;

public class Run {

    public static void main(String [] argv){
        System.out.print("Oeratori: ");
        int n = 0;
        while (true) {
            try {
                n = new Scanner(System.in).nextInt();
                break;
            } catch (Exception e) {
                System.out.println("metti un numero valido");
            }
        }

        Magazzino mag = new Magazzino();
        Operatori[] op = new Operatori[n];

        for (int i = 0;i < n;i++){
            op[i] = new Operatori(i+1, mag);
            op[i].start();
        }

        for (int i = 0;i < n;i++) {
            try {
                op[i].join();
            } catch (InterruptedException e) { }
        }
        System.out.println("\nMagazzino:");
        System.out.println(mag);
    }
}
