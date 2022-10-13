package main.java.com.bepis;

import java.util.Random;

public class InputDevice {

    public String getType(){
        return "random";
    }

    public int nextInt() {
        Random rand = new Random();
        return rand.nextInt(100);
    }
}
