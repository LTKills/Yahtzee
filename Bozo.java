package com.company;

/**
 * Created by bruno on 23/03/17.
 */
public class Bozo {

    private static int maxRodadas = 10;
    private int rodada;

    // Classe Placeholder, TODO: deletar depois
    public class RolaDados {
        public void rolar() {}

        public void rolar(String s) {}
    }

    public class Placar {
        public void add(int posicao, int[] dados) {}
        public int getScore() {return 10;};
        public java.lang.String toString() {return "String\n";}
    }

    public void main(String[] args) throws Exception {
        // TODO: Adicionar static depois na declaração

        RolaDados dados = new RolaDados();
        String input;
        int posicao;

        private int[5] diceToInt(String dice) {
            // TODO: this.
        }

        for (int i =0; i<this.maxRodadas; i++) {
            System.out.print("Rolando os dados...\n");
            dados.rolar();
            System.out.print(dados);

            input = EntradaTeclado.leString();
            if (input.length() != 0) { // o usuário quer manter 1 ou mais dados
                dados.rolar(input);
            } else {
                posicao = EntradaTeclado.leInt();


            }

        }
    }
}
