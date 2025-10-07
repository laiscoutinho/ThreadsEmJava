package org.sdistribuidos.question01;

public class Racer implements Runnable {
    private int id;
    private int repetitions;

    public Racer(int id, int repetitions) {
        this.id = id;
        this.repetitions = repetitions;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < repetitions) {
            System.out.println("Racer " + id + " - imprimindo (" + count + ")");
            count++;
        }
        System.out.println("Racer " + id + " finalizou.");
    }
}
