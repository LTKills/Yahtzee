package com.company;

import java.util.Arrays;

/**
 * Esta classe representa o placar de um jogo de Bozó.
 * Permite que combinações de dados sejam alocadas às posições e mantém o score de um jogador.
 * @author Bruno & Gabriel
 */
public class Placar {

    private int[] pontuacao = new int[10];
    private int naoOcupado = -1;

    /**
     * Inicializa o array com um valor flag que indica não ocupado
     */
    public Placar() {
        for (int i=0; i<10; i++)
            pontuacao[i] = naoOcupado;
    }

    /**
     * Adiciona uma sequencia de dados em uma determinada posição do placar.
     * Após a chamada, aquela posição torna-se ocupada e não pode ser usada uma segunda vez.
     * @param posicao: A posição que o usuário digitou
     * @param dados: Um array de inteiros, de tamanho 5. Cada posição corresponde a um valor de um dado.
     *             Supões-se que cada dado pode ter valor entre 1 e 6.
     * @throws java.lang.IllegalArgumentException
     *             Se a posição estiver ocupada ou se for passado um valor de posição inválido, essa exceção é lançada.
     *             Não é feita nenhuma verificação quanto ao tamanho do array nem quanto ao seu conteúdo.
     */
    void add(int posicao, int[] dados) throws java.lang.IllegalArgumentException {
        Arrays.sort(dados); // Ordenamos o array para facilita na verificação da pontuação.

        if ( posicao < 1 || posicao > 10 || pontuacao[posicao-1] != naoOcupado)   // posicao inválida
            throw new java.lang.IllegalArgumentException();

        if (posicao < 7) {      // soma dos dados
            int sum = 0;
            for(int i=0; i<5; i++)
                if (dados[i] == posicao) sum += posicao;
            pontuacao[posicao-1] = sum;
        }

        else if (posicao == 7) {    // full hand
            if ( (dados[0] == dados[1] && dados[1] == dados[2] && dados[3] == dados[4]) ||
                    (dados[0] == dados[1] && dados[2] == dados[3] && dados[3] == dados[4]) )
                pontuacao[posicao-1] = 15;
            else pontuacao[posicao-1] = 0;
        }

        else if (posicao == 8) {    // sequência
            if (dados[0] == dados[1]-1 && dados[1] == dados[2]-1 && dados[3] == dados[2]-1 && dados[4] == dados[3] -1)
                pontuacao[posicao-1] = 20;
            else
                pontuacao[posicao-1] = 0;
        }

        else if (posicao == 9) {    // quadra
            if ( (dados[0] == dados[1] && dados[1] == dados[2] && dados[2] == dados[3]) ||
                    (dados[1] == dados[2] && dados[2] == dados[3] && dados[3] == dados[4]))
                pontuacao[posicao-1] = 30;
            else
                pontuacao[posicao-1] = 0;
        }

        else {      // quina
            if (dados[0] == dados[1] && dados[1] == dados[2] && dados[2] == dados[3]  && dados[3] == dados[4])
                pontuacao[posicao-1] = 40;
            else
                pontuacao[posicao-1] = 0;
        }
    }

    /**
     * Computa a soma dos valores obtidos, considerando apenas as posições que já estão ocupadas.
     * @return O valor da soma.
     */
    public int getScore() {
        int sum = 0;
        for (int i=0; i<10; i++)
            if (pontuacao[i] != naoOcupado)
                sum += pontuacao[i];
        return sum;
    }

    @Override
    /**
     * A representação na forma de string, mostra o placar completo, indicando quais são as posições livres,
     * (com seus respectivos números) e o valor obtido nas posições já ocupadas.
     */
    public String toString() {
        String divisaoLinha = "------------------------------";
        String vazio = "         ";    // 11 espacos no total
        String fim = "+---------+";

        String[] array = new String[10];
        String pontuacaoFinal = "";
        for (int i=0; i<10; i++) {

            if (pontuacao[i] != naoOcupado)
                array[i] = String.format("   %02d    ", pontuacao[i]);
            else
                if (i != 9)
                    array[i] = String.format("   (%d)   ", i+1);
                else
                    array[i] = String.format("  (%d)   ", i+1);     // subtraimos um espaco para a formatacão
            if ( i < 3 || i > 5 ) array[i] += "|";
        }

        /* TODO: Deletar exemplo da formatação final abaixo
            (1)   |   (7)   |   (4)
         --------------------------
            (2)   |   20    |   (5)
         --------------------------
            00    |   30    |   (6)
         --------------------------
                  |   (10)  |
                  +---------+
         */
        return array[0] + array[6] + array[3] + "\n" + divisaoLinha + "\n"
                + array[1] + array[7] + array[4] + "\n" + divisaoLinha + "\n"
                + array[2] + array[8] + array[5] +"\n" + divisaoLinha + "\n"
                + vazio + "|" + array[9] + vazio + "\n" + vazio + fim + vazio + "\n";
    }
} 