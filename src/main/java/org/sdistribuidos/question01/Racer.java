package org.sdistribuidos.question01;

public class Racer implements Runnable {
    private int id;
    private final int repetitions = 1000;
    private int delay;

    public Racer(int id, int delay) {
        this.id = id;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int count = 0; count < repetitions; count++) {
            System.out.println("Racer " + id + " - imprimindo (" + count + ")");

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