public class Tabuleiro {
    // Método para gerar o tabuleiro
    public static char[][] gerarTabuleiro() {
        char[][] tabuleiro = new char[8][8];
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = '~'; // Representa a água
            }
        }
        return tabuleiro;
    }

    // Método para exibir o tabuleiro
    public static void exibirTabuleiro(char[][] tabuleiro) {
        System.out.println("   1 2 3 4 5 6 7 8");
        for (int i = 0; i < tabuleiro.length; i++) {
            char linha = (char) ('A' + i); // Converte índice para letra (A-H)
            System.out.print(linha + " ");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(" " + tabuleiro[i][j]);
            }
            System.out.println();
        }
    }
}
