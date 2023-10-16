package org.example;

public class Main {
    public static void main(String[] args) {
        ToyCollection toyCollection = new ToyCollection();

        toyCollection.addToy(new Toy(1, "конструктор", 20));
        toyCollection.addToy(new Toy(2, "робот", 20));
        toyCollection.addToy(new Toy(3, "кукла", 60));

        toyCollection.getAndWriteToOutput(10, "output.txt");
    }
}