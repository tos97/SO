package macchineIndustriali.object;

import java.io.Serializable;

public class Message implements Serializable {
    private String messaggio = "";

    public Message(String m){
        messaggio = m;
    }

    public String getMessage(){
        return messaggio;
    }
}
