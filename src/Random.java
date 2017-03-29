//package com.company;

import java.util.Calendar;

/**
 * Gerador simples de números aleatórios.
 * @author delamaro
 */

public class Random {

    private long p = 2147483648L;
    private long m = 843314861;
    private long a = 453816693;
    public long xi = 1023; // semente inicial

    /**
     * Construtor que permite criar o gerador, especificando o valor inicial da semente.
     * @param semente: O valor inicial da semente
     */
    public Random(int semente) {
        xi = semente;
    }


    /**
     * Construtor que usa uma semente aleatória, usando o método Calendar.getTimeInMillis().
     */
    public Random() {
        xi = Calendar.getInstance().getTimeInMillis();
    }


    /**
     * Permite alterar a semente de geração de números aleatórios.
     * Supostamente deve ser chamada antes de iniciar a geração, mas se for chamado a qualquer instante,
     * reseta o valor da semente
     * @param semente: o valor da nova semente
     */
    public void setSemente(int semente) {
        xi = semente;
    }

    /**
     * Retorna um número aleatório no intervalo (0,1[
     * @return o número gerado.
     */
    private double getRand() {
        // Calcula o próximo valor de xi, entre 0 e 1
        double next;
        xi = (a + m*xi) % p;
        next = xi / (double) p;
        return next;
    }


    /**
     * Retorna um valor inteiro no intervalo (0,max[
     * @param max: O valor limite para a geração do número inteiro
     * @return o número aleatório gerado.
     */
    public int getIntRand(int max) {
        // gera valor entre 0 e 1 e multiplica por max
        double rand = getRand() * max;
        return (int) rand + 1;
    }

}
