package org.example;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyCollection {
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>(new Comparator<Toy>() {
        @Override
        public int compare(Toy t1, Toy t2) {
            return Integer.compare(t2.getFrequency(), t1.getFrequency());
        }
    });

    private static int nextId = 1;

    public void addToy(Toy toy) {
        toyQueue.add(toy);
    }

    public Toy getToy() {
        int randomValue = new Random().nextInt(100);
        int threshold = 0;

        for (Toy toy : toyQueue) {
            threshold += toy.getFrequency();
            if (randomValue < threshold) {
                return toy;
            }
        }

        return null;
    }

    public void getAndWriteToOutput(int times, String outputFileName) {
        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            for (int i = 0; i < times; i++) {
                Toy toy = getToy();
                if (toy != null) {
                    writer.println("ID: " + toy.getId());
                    writer.println("Name: " + toy.getName());
                    writer.println("Frequency: " + toy.getFrequency());
                    writer.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}