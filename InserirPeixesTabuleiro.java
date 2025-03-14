import java.util.Random;

public class InserirPeixesTabuleiro {
    public static void inicializarMapaComItens(char[][] tabuleiro) {
        Random rand = new Random();

        // Colocando 8 peixes (P) aleatórios no mapa
        for (int i = 0; i < 8; i++) {
            int linha = rand.nextInt(6);
            int coluna = rand.nextInt(6);
            while (tabuleiro[linha][coluna] != '~') {
                linha = rand.nextInt(6);
                coluna = rand.nextInt(6);
            }
            tabuleiro[linha][coluna] = 'P'; // Insere um peixe
        }

        // Colocando 6 objetos (O) aleatórios no mapa
        for (int i = 0; i < 6; i++) {
            int linha = rand.nextInt(6);
            int coluna = rand.nextInt(6);
            while (tabuleiro[linha][coluna] != '~') {
                linha = rand.nextInt(6);
                coluna = rand.nextInt(6);
            }
            tabuleiro[linha][coluna] = 'O'; // Insere um objeto
        }

        //colocando 3 iscas - ao encontrar irá adicionar mais 3 tentativas para o player.
        for (int i = 0; i < 3; i++) {
            int linha = rand.nextInt(6);
            int coluna = rand.nextInt(6);
            while (tabuleiro[linha][coluna] != '~') {
                linha = rand.nextInt(6);
                coluna = rand.nextInt(6);
            }
            tabuleiro[linha][coluna] = 'J'; // Inseri iscas
        }
    }
}