

import java.io.IOException;

/**
 * Essa � a classe inicial do programa Boz�. Possui apenas o m�todo main, que cuida da execu��o do jogo.
 * @author Bruno & Gabriel
 */
public class Bozo {

    private static int maxRodadas = 10;
    //private int rodada;

    /**
     * M�todo inicial do programa. Ele cuida da execu��oo do jogo e possui um la�o,
     * no qual cada itera��o representa uma rodada do jogo. Em cada rodada, o jogador joga os dados até 3 vezes,
     * e depois escolhe a posi��o do placar que deseja preencher. No final das rodadas a pontua��o total � exibida.
     * @throws IOException caso algum input digitado não seja o correto.
     */
    public static void bmain() throws IOException {

        RolaDados dados = new RolaDados(5);
        Placar placar = new Placar();
        String input;

        int[] vector = new int[5];

        for (int i = 0; i < maxRodadas; i++) {
            System.out.print("Pressione Enter para come�ar a rodada...\n");
            EntradaTeclado.leString();

            dados.rolar();
            System.out.print(dados);

            System.out.println("Quer mudar quais dados? (Enter para prosseguir)");
            input = EntradaTeclado.leString();
            
            // verificamos se o usuário quer mudar algum dado por meio de input.lenght()
            
            for(int j = 0; j < 2 && input.length() != 0; j += 1) {
                vector = dados.rolar(input);
                System.out.print(dados);
                System.out.println("Quer mudar quais dados? (Enter para prosseguir)");
                input = EntradaTeclado.leString();
            }

            System.out.print("Digite a posi��o em que quer inserir: ");
            int posicao = EntradaTeclado.leInt();
            while (true) {
                try {
                    placar.add(posicao, vector);
                    break;
                } catch (java.lang.IllegalArgumentException exception) {
                    System.out.print("Posi��o inv�lida, insira um n�mero de 1 a 10 que ainda n�o foi usado.\n");
                    posicao = EntradaTeclado.leInt();
                }
            }

            System.out.print(placar);
        }

        System.out.printf("Seu score final �: %d\n", placar.getScore());
    }
}