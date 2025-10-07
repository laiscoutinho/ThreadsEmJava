package org.sdistribuidos.question01;

public class RacerThread extends Thread {
    private final int repetitions = 1000;
    private int delay;

    public RacerThread(int id, int delay) {
        super("Racer " + id);
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int count = 0; count < repetitions; count++) {
            System.out.println(getName() + " - imprimindo (" + count + ")");

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                this.interrupt();
                System.err.println(getName() + " interrompido.");
            }
        }
        System.out.println(getName() + " finalizou.");
    }
}