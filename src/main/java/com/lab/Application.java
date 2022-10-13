package main.java.com.lab;

import java.util.Arrays;

public class Application {
    InputDevice inputDevice;
    OutputDevice outputDevice;

    public Application(InputDevice inputDevice, OutputDevice outputDevice) {
        this.inputDevice = inputDevice;
        this.outputDevice = outputDevice;
    }

    public void run(){
        System.out.println(Arrays.toString(this.inputDevice.getNumbers(10)));
    }
}