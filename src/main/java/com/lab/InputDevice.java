package main.java.com.lab;

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
