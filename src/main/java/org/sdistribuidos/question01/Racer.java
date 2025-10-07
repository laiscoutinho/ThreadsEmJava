package org.sdistribuidos.question01;

public class Racer implements Runnable {
    private int id;
    private int repetitions;
    private int delay;

    public Racer(int id, int repetitions, int delay) {
        this.id = id;
        this.repetitions = repetitions;
        this.delay = delay;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < repetitions) {
            System.out.println("Racer " + id + " - imprimindo (" + count + ")");
            count++;

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Racer " + id + " interrompido.");
            }
        }
        System.out.println("Racer " + id + " finalizou.");
    }
}