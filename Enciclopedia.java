import java.util.Scanner;

public class Enciclopedia {
public static int escolherCategoria () {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Aqui você poderá consultar todos os peixes presentes no jogo!");
	System.out.println("Escolha a categoria que deseja conhecer: \n 1. Costa brasileira \n 2. Amazônia \n 3. Cerrado");
	int decisaodificuldade = scanner.nextInt();
	while (decisaodificuldade <= 0 || decisaodificuldade > 3) {
		System.out.println("Categoria inválida \n Digite novamente:");
	}
	return decisaodificuldade;
}
public static String [] peixes (int decisaodificuldade) {
	String [] peixes = {};

	    switch (decisaodificuldade) {
        case 1: 
        peixes = new String[]{"Carapau", "Corvina", "Robalo", "Tainha", "Sororoca", "Pargo", "Anchova", "Garoupa", "Xareu", "Namorado","Atum", "Dourado", "Olhete", "Cavala", "Pirauna" };   
        break;
         
        case 2:
        peixes = new String[]{"Tucunare", "Aruana", "Oscar", "Traina", "Matrinxa", "Tabanara", "Piraputanga", "Jundia","Pacu", "Dourado","Tambaqui", "Pirarucu", "Pirarara", "Piraiba", "Pintado"};
        break;
     
        case 3:
        peixes = new String[]{"Piauizinho", "Piaba", "Voadeira", "Aracu", "Bagre", "Tilapia", "Acara", "Jacunda","Cascudo", "Traira", "Tucunare", "Violinha","Pirapitinga", "Cachara", "Carpa"};
        break;
        }
	    return peixes;
}
public static void imprimirPeixes () {
	Scanner scanner = new Scanner(System.in);
	int categoriaEscolhida = escolherCategoria();
	
	String [] listaPeixes = peixes(categoriaEscolhida);
	
	System.out.println("Esses são os peixes disponíveis na categoria escolhida:");
	for (String peixes : listaPeixes) {
		System.out.println(peixes);
	}
  System.out.println("Deseja fazer algo mais? \n 1. Sim, quero verificar outra categoria \n 2. Voltar ao menu principal");
  int decisao = scanner.nextInt();
      switch (decisao) {
      case 1: 
    	  Enciclopedia.imprimirPeixes();
      case 2:
    	  break;
      }
}
}

