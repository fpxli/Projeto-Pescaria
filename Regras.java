import java.util.Scanner;

public class Regras {
public static void Regras () {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Aqui você pode verificar as regras de funcionamento do jogo! \n");
	System.out.println("O jogo é um multiplayer PVP composto por 2 jogadores.\nO objetivo é pescar a maior quantidade em kg de peixes dentro da quantidade de chances disponíveis. \n");
	System.out.println("Cada jogador inicia a partida com a mesma quantidade de iscas, variando de 3-5 dependendo do cenário. \nTambém é possível obter mais iscas durante a partida, caso pesque alguma, da mesma forma é possível perder alguma caso pesque um iten indesejado \n");
	System.out.println("Para pescar o peixe inicialmente é necessário que acerte a coordenada que ele está (Ex: C4). \nPara pesca-lo é necessário que corrija o seu nome embaralhado em menos de 10 segundos \nCaso o jogador acerte o peixe mas erre seu nome, o peixe fugirá e a coordenada será bloqueada\n");
	System.out.printf("\u001B[33mVence o jogador que pescar a maior quantidade de kgs\n");
	System.out.printf("\n\u001B[37mEm caso de empate em kgs, a partida será decidida na quantidade de peixes pescados");
    System.out.println("Deseja voltar ao menu principal? \n 1. Sim \n 2. Não");
    int escolha = scanner.nextInt();
    while (escolha != 1) {
    	Regras.Regras();
    }
}
}