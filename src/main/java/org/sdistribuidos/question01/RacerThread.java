package org.sdistribuidos.question01;

public class RacerThread extends Thread {
    private int repetitions;
    private int delay;

    public RacerThread(int id, int repetitions, int delay) {
        super("Racer " + id);
        this.repetitions = repetitions;
        this.delay = delay;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < repetitions) {
            System.out.println(getName() + " - imprimindo (" + count + ")");
            count++;

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