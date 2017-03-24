package com.company;

import java.util.Calendar;

/**
 * Created by bruno on 16/03/17.
 */

public class Random {

    private long p = 2147483648L;
    private long m = 843314861;
    private long a = 453816693;
    public long xi = 1023; // semente inicial

    /**
     * Permite definir a semente usada para gerar os números aleatórios
     * @param semente: semente inicial para ser inicializada.
     */
    public Random(int semente) {
        xi = semente;
    }

    /**
     * Se o usuário não forncece nenhuma semente, usamos o relógio da máquina
     */
    public Random() {
        xi = Calendar.getInstance().getTimeInMillis();
    }


    /**
     * Calcula um número aleatório entre 0 1
     * @return o número calculado, em double.
     */
    private double getRand() {
        // Calcula o próximo valor de xi, entre 0 e 1
        double next;
        xi = (a + m*xi) % p;
        next = xi / (double) p;
        return next;
    }

    /**
     * Gera um número aleatório
     * @param max
     * @return
     */
    public int getIntRand(int max) {
        // gera valor entre 0 e 1 e multiplica por max
        double rand = getRand() * max;
        return (int) rand + 1;
    }

}
