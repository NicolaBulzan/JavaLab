package main.java.com.lab.fruits;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

abstract public class Fruit implements Comparable<Fruit> {
    private double weight;
    private double water_content;
    private double sugar_content;
    private Color color;


    public double getSugar_content() {
        return sugar_content;
    }

    public void setSugar_content(double sugar_content) {
        this.sugar_content = sugar_content;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWater_content() {
        return water_content;
    }

    public void setWater_content(double water_content) {
        this.water_content = water_content;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static double computeWeight(Collection<Fruit> fruits) {
        double totalWeight = 0;
        for(Fruit f: fruits){
            totalWeight += f.getWeight();
        }
        return totalWeight;
    }

    public static double computeWeight(Fruit[] fruits) {
        double totalWeight = 0;
        for(Fruit f: fruits){
            totalWeight += f.getWeight();
        }
        return totalWeight;
    }

    public static double computeSugarContent(Collection<Fruit> fruits) {
        double totalSugarContent = 0;
        for(Fruit f: fruits){
            totalSugarContent += f.getSugar_content();
        }
        return totalSugarContent;
    }

    public static double computeSugarContent(Fruit[] fruits) {
        double totalSugarContent = 0;
        for(Fruit f: fruits){
            totalSugarContent += f.getSugar_content();
        }
        return totalSugarContent;
    }

    public static void prepareFruit(Collection<Fruit> fruits) {
        for (Fruit f: fruits){
            if(f instanceof Peelable){
                ((Peelable) f).peelOff();
            }
            if(f instanceof SeedRemovable){
                ((SeedRemovable) f).removeSeeds();
            }
        }
    }

    public static void prepareFruit(Fruit[] fruits) {
        for (Fruit f: fruits){
            if(f instanceof Peelable){
                ((Peelable) f).peelOff();
            }
            if(f instanceof SeedRemovable){
                ((SeedRemovable) f).removeSeeds();
            }
        }
    }

    public static HashMap<String, Integer> countFruit(Collection<Fruit> fruits){
        HashMap<String, Integer> fruitMap = new HashMap<String, Integer>();
        for (Fruit f : fruits){
            String fruit_class_name = f.getClass().getSimpleName();
            if(fruitMap.containsKey(f.getClass().getSimpleName())){
                fruitMap.put(fruit_class_name, fruitMap.get(fruit_class_name) + 1);
            }
            else{
                fruitMap.put(fruit_class_name, 1);
            }
        }
        return fruitMap;
    }

    @Override
    public int compareTo(Fruit o) {
        if(this.weight > o.weight) {
            return 1;
        }
        else if(this.weight == o.weight){
            if(this.sugar_content > o.sugar_content){
                return 1;
            } else if (this.sugar_content == o.sugar_content){
                return 0;
            }
        }
        return -1;
    }

    public static String mostPopular(Collection<Fruit> fruits){
        HashMap<String, Integer> fruitMap = Fruit.countFruit(fruits);
        int max_val = Collections.max(fruitMap.values());
        for (Map.Entry<String, Integer> entry: fruitMap.entrySet()){
            if(entry.getValue() == max_val){
                return entry.getKey();
            }
        }
        return null;
    }

    public enum Color {
        RED,
        YELLOW,
        PURPLE,
        GREEN
    }
}

