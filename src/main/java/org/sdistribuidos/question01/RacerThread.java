package org.sdistribuidos.question01;

public class RacerThread extends Thread {
    private int repetitions;

    public RacerThread(int id, int repetitions) {
        super("Racer " + id);
        this.repetitions = repetitions;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < repetitions) {
            System.out.println(getName() + " - imprimindo (" + count + ")");
            count++;
        }
        System.out.println(getName() + " finalizou.");
    }
}
