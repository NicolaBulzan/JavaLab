package main.java.com.bepis;

public class Application {
    InputDevice inputDevice;
    OutputDevice outputDevice;

    public Application(InputDevice inputDevice, OutputDevice outputDevice) {
        this.inputDevice = inputDevice;
        this.outputDevice = outputDevice;
    }

    public void run(){
        outputDevice.writeMessage("Application started.");
        outputDevice.writeMessage("Today's lucky numbers are: ");
        outputDevice.writeMessage(inputDevice.nextInt());
        outputDevice.writeMessage(Integer.toString(inputDevice.nextInt()));
    }
}
