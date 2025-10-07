package org.sdistribuidos.question01;

import java.util.ArrayList;
import java.util.List;

public class Race {
    public static void main(String[] args) {
        List<Thread> racers = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            int delay = (int) (Math.random() * 200);

            Thread t = (i % 2 == 0)
                    ? new RacerThread(i, delay)
                    : new Thread(new Racer(i, delay));

            racers.add(t);
        }

        System.out.println("=== Iniciando corrida ===");

        // Inicia threads ímpares
        for (int i = 0; i < racers.size(); i++) {
            if (i % 2 != 0) {
                racers.get(i).start();
            }
        }

        // Aguarda threads ímpares terminarem
        for (int i = 0; i < racers.size(); i++) {
            if (i % 2 != 0) {
                try {
                    racers.get(i).join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        // Inicia threads pares apenas após ímpares finalizarem
        for (int i = 0; i < racers.size(); i++) {
            if (i % 2 == 0) {
                racers.get(i).start();
            }
        }

        // Aguarda todas as threads terminarem
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

