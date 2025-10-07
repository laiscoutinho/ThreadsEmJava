package org.sdistribuidos.question02;

public class Produtor extends Thread {
    private Deposito deposito;
    private int delay;

    public Produtor(Deposito deposito, int delay) {
        this.deposito = deposito;
        this.delay = delay;
    }

    @Override
    public void run() {
        int produzido = 0;
        while (produzido < 100) {
            deposito.colocar();
            produzido++;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Produtor finalizou a produção de 100 caixas.");
    }
}