package macchinaIndustrialeComplesso;

import java.io.Serializable;

public class Message implements Serializable {
    private String messaggio = "";

    public Message(String m){
        this.messaggio = m;
    }

    public String getMessage(){
        return messaggio;
    }
}
