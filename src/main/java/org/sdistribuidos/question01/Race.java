package org.sdistribuidos.question01;

import java.util.ArrayList;
import java.util.List;

public class Race {
    public static void main(String[] args) {
        List<Thread> racers = new ArrayList<>();

        // Criação de 10 racers (identificadores 1 a 10)
        for (int i = 1; i <= 10; i++) {
            int repetitions = 3;
            int delay = (int) (Math.random() * 200);

            Thread t = (i % 2 == 0)
                    ? new RacerThread(i, repetitions, delay)
                    : new Thread(new Racer(i, repetitions, delay));

            // Definição de prioridade: 1 a 5 baixa, 6 a 10 alta
            if (i <= 5) {
                t.setPriority(Thread.MIN_PRIORITY); // menor prioridade
            } else {
                t.setPriority(Thread.MAX_PRIORITY); // maior prioridade
            }

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

