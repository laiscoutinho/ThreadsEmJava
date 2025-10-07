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
            // verifica se há itens disponíveis antes de tentar retirar
            if (deposito.getNumItens() > 0) {
                deposito.retirar();
                consumido++;
            } else {
                // se o depósito estiver vazio, aguarda 200 ms antes de tentar novamente
                System.out.println(getName() + " aguardando 200 ms — depósito vazio.");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(getName() + " finalizou o consumo de 20 caixas.");
    }
}