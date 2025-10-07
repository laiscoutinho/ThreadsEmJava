package org.sdistribuidos.question02;

public class Consumidor extends Thread {
    private Deposito deposito;
    private int delay;

    public Consumidor(Deposito deposito, int delay) {
        this.deposito = deposito;
        this.delay = delay;
    }

    @Override
    public void run() {
        int consumido = 0;
        while (consumido < 20) {
            deposito.retirar();
            consumido++;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(getName() + " finalizou o consumo de 20 caixas.");
    }
}