package main.java.com.lab;

import java.util.Arrays;

public class Application {
    InputDevice inputDevice;
    OutputDevice outputDevice;

    public Application(InputDevice inputDevice, OutputDevice outputDevice) {
        this.inputDevice = inputDevice;
        this.outputDevice = outputDevice;
    }

    public void sortNumbers(int[] numbers){
        Arrays.sort(numbers);
    }

    public void randomArraySort(){
        int[] numbers = this.inputDevice.getNumbers(10);
        System.out.println(Arrays.toString(numbers));
        this.sortNumbers(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public void run(){
        this.randomArraySort();
    }
}