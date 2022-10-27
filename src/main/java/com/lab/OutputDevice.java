package main.java.com.lab;

import java.util.Map;

public class OutputDevice {

    public void writeMessage(String mess) {
        System.out.println(mess);
    }

    public void writeMessage(Double mess) {
        System.out.println(mess);
    }

    public void writeMessage(int numericalMessage) {
        System.out.println(numericalMessage);
    }

    public <K, V> void writeMessage(Map<K, V> mapMessage){
        System.out.println(mapMessage);
    }

    public <T> void writeMessage(T message) {
        System.out.println(message);
    }

    public void writeMessage(String[] messArr) {
        for(String arg: messArr){
            this.writeMessage(arg);
        }
    }

}
