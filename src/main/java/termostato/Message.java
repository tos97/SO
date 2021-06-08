package termostato;

import java.io.Serializable;

public class Message implements Serializable {
    private float message;

    public Message(float message){
        this.message = message;
    }

    public float getMessage(){
        return this.message;
    }
}
