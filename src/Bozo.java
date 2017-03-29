

import java.io.IOException;

/**
 * Essa é a classe inicial do programa Bozó. Possui apenas o método main, que cuida da execução do jogo.
 * @author Bruno & Gabriel
 */
public class Bozo {

    private static int maxRodadas = 10;
    //private int rodada;

    /**
     * Método inicial do programa. Ele cuida da execuçãoo do jogo e possui um laço,
     * no qual cada iteração representa uma rodada do jogo. Em cada rodada, o jogador joga os dados atÃ© 3 vezes,
     * e depois escolhe a posição do placar que deseja preencher. No final das rodadas a pontuação total é exibida.
     * @throws IOException caso algum input digitado nÃ£o seja o correto.
     */
    public static void bmain() throws IOException {

        RolaDados dados = new RolaDados(5);
        Placar placar = new Placar();
        String input;

        int[] vector = new int[5];

        for (int i = 0; i < maxRodadas; i++) {
            System.out.print("Pressione Enter para começar a rodada...\n");
            EntradaTeclado.leString();

            dados.rolar();
            System.out.print(dados);

            System.out.println("Quer mudar quais dados? (Enter para prosseguir)");
            input = EntradaTeclado.leString();
            
            // verificamos se o usuÃ¡rio quer mudar algum dado por meio de input.lenght()
            
            for(int j = 0; j < 2 && input.length() != 0; j += 1) {
                vector = dados.rolar(input);
                System.out.print(dados);
                System.out.println("Quer mudar quais dados? (Enter para prosseguir)");
                input = EntradaTeclado.leString();
            }

            System.out.print("Digite a posição em que quer inserir: ");
            int posicao = EntradaTeclado.leInt();
            while (true) {
                try {
                    placar.add(posicao, vector);
                    break;
                } catch (java.lang.IllegalArgumentException exception) {
                    System.out.print("Posição inválida, insira um número de 1 a 10 que ainda não foi usado.\n");
                    posicao = EntradaTeclado.leInt();
                }
            }

            System.out.print(placar);
        }

        System.out.printf("Seu score final é: %d\n", placar.getScore());
    }
}