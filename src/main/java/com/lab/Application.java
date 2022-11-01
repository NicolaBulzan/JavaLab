package main.java.com.lab;

import main.java.com.lab.fruits.Fruit;
import main.java.com.lab.fruits.Peelable;
import main.java.com.lab.fruits.SeedRemovable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

public class Application {
    InputDevice inputDevice;
    OutputDevice outputDevice;
    String arg;

    public Application(InputDevice inputDevice, OutputDevice outputDevice, String arg) {
        this.inputDevice = inputDevice;
        this.outputDevice = outputDevice;
        this.arg = arg;
    }

    private void sortNumbers(int[] numbers){
        Arrays.sort(numbers);
    }

    private void randomArraySort(){
        int[] numbers = this.inputDevice.getNumbers(10);
        System.out.println(Arrays.toString(numbers));
        this.sortNumbers(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private int[] wordSizeHistogram(String sentence){
        int[] histogram = new int[7];
        // Initialize to size of 7, then split the sentence on spaces and iterate through each word.
        for(String word: sentence.split(" ")){

            // Checks if the length of the word is greater than the length of the histogram array.
            // This is needed because if we have a word of length 7 it will try to store it at histogram[7], which for
            // Our declaration, is out of bounds, so we copy the histogram in a new array with the length + 1
            if (word.length() >= histogram.length){
                histogram = Arrays.copyOf(histogram, histogram.length + 1);
            }
            histogram[word.length()] += 1;
        }

        return histogram;
    }

    private void exampleHistogram() {
        System.out.println(Arrays.toString(this.wordSizeHistogram(inputDevice.getLine())));
    }

    private void testFruitStuff() {
        ArrayList<Fruit> fruits = inputDevice.readFruit();

        outputDevice.writeMessage(Fruit.computeSugarContent(fruits));
        outputDevice.writeMessage(Fruit.computeWeight(fruits));
        Fruit.prepareFruit(fruits);
        outputDevice.writeMessage(Fruit.countFruit(fruits));

        for (Fruit f: fruits){
            if(f instanceof Peelable){
                System.out.println(((Peelable) f).hasPeel());
            }
            if(f instanceof SeedRemovable){
                System.out.println(((SeedRemovable) f).hasSeeds());
            }
        }
    }

    private void testFruitComparison(){
        ArrayList<Fruit> fruits = inputDevice.readFruit();
        outputDevice.writeMessage(fruits);
        outputDevice.writeMessage(Collections.max(fruits));
        outputDevice.writeMessage(Collections.min(fruits));
        Collections.sort(fruits);
        outputDevice.writeMessage(fruits);
        outputDevice.writeMessage(Fruit.mostPopular(fruits));

    }

    private void testFruitStreams(){
        ArrayList<Fruit> fruits = inputDevice.readFruit();
        Stream<Fruit> filteredFruits = fruits.stream().filter(fruit -> fruit.getSugar_content() < 20);
        filteredFruits.forEach(x -> outputDevice.writeMessage(x));

        double sugarContent = fruits.stream().map(Fruit::getSugar_content).reduce((double) 0, Double::sum);
        outputDevice.writeMessage(sugarContent);

        fruits.stream().map(f -> f.getSugar_content() / f.getWater_content()).forEach(outputDevice::writeMessage);
    }

    public void run(){

        if (arg.equals("words")){
            this.exampleHistogram();
        } else if (arg.equals("numbers")){
            this.randomArraySort();
        }

//        this.testFruitStuff();
//        this.testFruitComparison();
        this.testFruitStreams();



    }
}