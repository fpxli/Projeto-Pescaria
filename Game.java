import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            exibirMenu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    iniciarNovaPescaria();
                    break;
                case 2:
                    Enciclopedia.imprimirPeixes();
                    break;
                case 3:
                    Regras.Regras();
                    break;
                case 4:
                    rodando = false;
                    System.out.println("Obrigado por jogar! Até a próxima.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            System.out.println();
        }

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("==================================");
        System.out.println("     Bem-vindo ao Game de Pesca!");
        System.out.println("==================================");
        System.out.println("1. Iniciar nova pescaria");
        System.out.println("2. Ver lista de peixes");
        System.out.println("3. Regras");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void iniciarNovaPescaria() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione uma dificuldade:");
        System.out.println("1 - Oceano brasileiro");
        System.out.println("2 - Amazônia");
        System.out.println("3 - Cerrado");
        int dificuldade = scanner.nextInt();
    
        // Gerar o tabuleiro real (com água)
        char[][] tabuleiroReal = Tabuleiro.gerarTabuleiro();
    
        // Inicializar o tabuleiro real com peixes (P) e objetos (O)
        InserirPeixesTabuleiro.inicializarMapaComItens(tabuleiroReal);
    
        // Iniciar o jogo com o tabuleiro real
        Pescaria.jogoRodando(dificuldade, tabuleiroReal);
    }
    
}