package main.java.com.lab;

import java.util.Random;

public class InputDevice {

    public String getType(){
        return "random";
    }

    public int[] getNumbers(int n){
        int[] numbers = new int[n];
        for(int idx = 0; idx < n;idx++){
            numbers[idx] = this.nextInt();
        }

        return numbers;
    }

    public int nextInt() {
        Random rand = new Random();
        return rand.nextInt(100);
    }
}
