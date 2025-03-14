import java.util.Random;
import java.util.Scanner;

public class Pescaria {
    public static void jogoRodando(int dificuldade, char [][] tabuleiroReal ) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        char[][] tabuleiroVisivel = Tabuleiro.gerarTabuleiro(); // Cria o tabuleiro visível
        int iscas1, iscas2; 
        int peixesPescados1 = 0, peixesPescados2 = 0;
        double pesoPescado1 = 0.0, pesoPescado2 = 0.0;

        // Configuração inicial de iscas
        switch (dificuldade) {
            case 1: // Oceano brasileiro
                iscas1 = iscas2 = 5;
                break;
            case 2: // Amazônia
                iscas1 = iscas2 = 5;
                break;
            case 3: // Cerrado
                iscas1 = iscas2 = 3;
                break;
            default:
                System.err.println("Dificuldade inválida! Começando com dificuldade padrão.");
                iscas1 = iscas2 = 5;
        }

        // Iniciar o jogo
        int jogadorAtual = 1; 
        System.out.println("Você começou a pescaria. Boa sorte!");
        while (iscas1 > 0 || iscas2 > 0) {
            if (jogadorAtual == 1 && iscas1 <= 0) {
                System.out.println("Jogador 1 não tem mais iscas! Passando para o jogador 2.");
                jogadorAtual = 2; 
                continue;
            }

            if (jogadorAtual == 2 && iscas2 <= 0) {
                System.out.println("Jogador 2 não tem mais iscas! Passando para o jogador 1.");
                jogadorAtual = 1; 
                continue;
            }

            System.out.println("\nTabuleiro atual:");
            Tabuleiro.exibirTabuleiro(tabuleiroVisivel);

            System.out.println("\nJogador " + jogadorAtual + ", escolha uma posição para jogar a isca (exemplo: A1): ");
            System.out.print("Linha (A-H): ");
            char linhaChar = scanner.next().toUpperCase().charAt(0);
            System.out.print("Coluna (1-8): ");
            int coluna = -1;

            // Validar a linha
            int linha = linhaChar - 'A';
            if (linha < 0 || linha >= 8) {
                System.out.println("Coordenada inválida! Tente novamente.");
                continue;
            }

            // Validar a coluna
            boolean entradaValida = false;
            while (!entradaValida) {
                try {
                    coluna = Integer.parseInt(scanner.next()) - 1;
                    if (coluna < 0 || coluna >= 8) {
                        System.out.println("Coluna inválida! A coluna deve ser entre 1 e 8.");
                    } else {
                        entradaValida = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida! Por favor, insira um número para a coluna.");
                }
            }

            // Verificar se a posição já foi jogada
            if (tabuleiroVisivel[linha][coluna] != '~') {
                System.out.println("Você já escolheu essa posição! Tente outra.");
                continue;
            }

            char conteudo = tabuleiroReal[linha][coluna];
            tabuleiroVisivel[linha][coluna] = conteudo;

            // Lógica de pescaria
            if (conteudo == 'P') {
                System.out.println("Você encontrou um peixe! Parabéns!");

                // Escolher o tamanho do peixe aleatoriamente
                int tamanhoPeixe = random.nextInt(3) + 1;
                String[] listaPeixes = Peixes.gerarPeixes(dificuldade, tamanhoPeixe);
                String nomeEmbaralhado = Peixes.nomeEmbaralhado(listaPeixes);

                System.out.println("\nO nome do peixe está embaralhado! Resolva o desafio:");
                System.out.println("Nome embaralhado: " + nomeEmbaralhado);
                System.out.print("Digite o nome correto: ");
                String resposta = scanner.next();

                double peso = 0.0;

                if (Peixes.isNomeCorreto(listaPeixes, resposta)) {
                    peso = Peixes.calcularPesoPeixe(resposta, dificuldade);
                    System.out.printf("Parabéns! Você acertou. O peixe %s pesa %.2f kg.\n", resposta, peso);
                } else {
                    System.out.println("Você errou o nome do peixe... Ele fugiu!");
                }

                if (jogadorAtual == 1) {
                    peixesPescados1++;
                    pesoPescado1 += peso;
                } else {
                    peixesPescados2++;
                    pesoPescado2 += peso;
                }

            } else if (conteudo == 'O') {
                System.out.println("Você encontrou um objeto... Não foi dessa vez.");
                String[] objetos = Objetos.gerarObjetos();
                String objetoPescado = objetos[random.nextInt(objetos.length)];
                System.out.println(Objetos.mensagemParaObjeto(objetoPescado));
            } else if (conteudo == 'J') {
                int novasIscas = Cardume.encontrarIscas();
                if (jogadorAtual == 1) {
                    iscas1 += novasIscas;
                    System.out.println("\nSuas iscas agora são: " + iscas1);
                } else {
                    iscas2 += novasIscas;
                    System.out.println("\nSuas iscas agora são: " + iscas2);
                }
            } else {
                System.out.println("Água! Nada encontrado.");
                tabuleiroVisivel[linha][coluna] = 'X';
            }

            // Reduzir o número de iscas restantes do jogador atual
            if (jogadorAtual == 1) {
                iscas1--;
                System.out.println("Iscas restantes do Jogador 1: " + iscas1);
            } else {
                iscas2--;
                System.out.println("Iscas restantes do Jogador 2: " + iscas2);
            }

            // Troca de jogador: se o jogador atual for 1, passa para 2, e vice-versa
            jogadorAtual = (jogadorAtual == 1) ? 2 : 1;
        }

        // Exibir o fim do jogo e o resultado
        System.out.println("\nFim da pescaria! Ambos os jogadores ficaram sem iscas.");
        System.out.printf("\nJogador 1 pescou %d peixes, com um peso total de %.2fKg.\n", peixesPescados1, pesoPescado1);
        System.out.printf("\nJogador 2 pescou %d peixes, com um peso total de %.2fKg.\n", peixesPescados2, pesoPescado2);

        // Determinar o vencedor com base no peso pescado
        if (pesoPescado1 > pesoPescado2) {
            System.out.printf("Jogador 1 é o vencedor! Peso total pescado: %.2fKg.\n", pesoPescado1);
        } else if (pesoPescado2 > pesoPescado1) {
            System.out.printf("Jogador 2 é o vencedor! Peso total pescado: %.2fKg.\n", pesoPescado2);
        } else {
           if (peixesPescados1 > peixesPescados2) {
        	   System.out.println("Houve empate em peso pescado, porém:");
        	   System.out.println("O Jogador 1 é o vencedor! Pois pescou mais peixes, sendo: " + peixesPescados1);
           }
           else {
        	   System.out.println("Houve empate em peso pescado, porém:");
        	   System.out.println("O Jogador 2 é o vencedor! Pois pescou mais peixes, sendo: " + peixesPescados2);
           }
        }

        System.out.println("\nTabuleiro final:");
        Tabuleiro.exibirTabuleiro(tabuleiroVisivel);
    }
}
