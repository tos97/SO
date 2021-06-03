package TerminazionThread;

import java.util.Scanner;

public class Run {
    public static void main(String [] argv){
        if (argv.length == 0)
            System.out.println("ERRORE");

        ProcessiThread pp[] = new ProcessiThread[Integer.parseInt(argv[0])];
        boolean running[] = new boolean[Integer.parseInt(argv[0])];

        for(int i = 0;i < Integer.parseInt(argv[0]);i++){
            pp[i] = new ProcessiThread(i);
            pp[i].start();
            running[i] = true;
        }

        while (checkThread(running) > 0){
            try {
                int c = new Scanner(System.in).nextInt();
                if(c >= 0 && c < Integer.parseInt(argv[0])) {
                    if (running[c] == true) {
                        pp[c].stop();
                        running[c] = false;
                    }
                    else{
                        System.out.println("già morto");
                    }
                }
                else{
                    System.out.println("fouri bound");
                }
            }catch (NumberFormatException e){
                System.out.println("devi inserire un numero");
            }
        }

    }

    public static int checkThread(boolean array[]){
        int threadAttivi = 0;
        for (boolean bol: array){
            if (bol == true)
                threadAttivi++;
        }
        return threadAttivi;
    }
}
