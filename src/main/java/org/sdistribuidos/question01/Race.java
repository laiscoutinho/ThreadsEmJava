package org.sdistribuidos.question01;

import java.util.ArrayList;
import java.util.List;

public class Race {
    public static void main(String[] args) {
        List<Thread> racers = new ArrayList<>();
        int repetitions = 3;

        // Criação de 10 racers (identificadores 1 a 10)
        for (int i = 1; i <= 10; i++) {
            Thread t = (i % 2 == 0)
                    ? new RacerThread(i, repetitions)
                    : new Thread(new Racer(i, repetitions));

            racers.add(t);
        }

        System.out.println("=== Iniciando corrida ===");

        for (Thread t : racers) {
            t.start();
        }

        for (Thread t : racers) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("=== Corrida finalizada ===");
    }
}
