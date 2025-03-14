import java.util.Random;

public class Cardume {
    // Método para encontrar iscas
    public static int encontrarIscas() {
        Random rand = new Random();
        // Gerar uma quantidade aleatória de iscas, por exemplo, entre 1 e 3
        int iscasEncontradas = rand.nextInt(3) + 3;
        System.out.printf("Você encontrou um cardume de iscas! Ganhou %d iscas ", iscasEncontradas);
        return iscasEncontradas;
    }
}