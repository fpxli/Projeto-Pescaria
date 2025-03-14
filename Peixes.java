import java.util.*;

public class Peixes {
    public static String[] gerarPeixes(int dificuldade, int tamanhoPeixe) {
        String[] peixes = {};
        switch (dificuldade) {
            case 1:
                peixes = switch (tamanhoPeixe) {
                    case 1 -> new String[]{"Carapau", "Corvina", "Robalo", "Tainha", "Sororoca", "Pargo"};
                    case 2 -> new String[]{"Anchova", "Garoupa", "Xareu", "Namorado"};
                    case 3 -> new String[]{"Atum", "Dourado", "Olhete", "Cavala", "Pirauna"};
                    default -> peixes;
                };
                break;
            case 2:
                peixes = switch (tamanhoPeixe) {
                    case 1 -> new String[]{"Tucunare", "Aruana", "Oscar", "Traina", "Matrinxa", "Tabanara", "Piraputanga", "Jundia"};
                    case 2 -> new String[]{"Pacu", "Dourado"};
                    case 3 -> new String[]{"Tambaqui", "Pirarucu", "Pirarara", "Piraiba", "Pintado"};
                    default -> peixes;
                };
                break;
            case 3:
                peixes = switch (tamanhoPeixe) {
                    case 1 -> new String[]{"Piauizinho", "Piaba", "Voadeira", "Aracu", "Bagre", "Tilapia", "Acara", "Jacunda"};
                    case 2 -> new String[]{"Cascudo", "Traira", "Tucunare", "Violinha"};
                    case 3 -> new String[]{"Pirapitinga", "Cachara", "Carpa"};
                    default -> peixes;
                };
                break;
        }
        return peixes;
    }

    public static String nomeEmbaralhado(String[] peixes) {
        Random rand = new Random();
        String peixe = peixes[rand.nextInt(peixes.length)];
        List<Character> charList = new ArrayList<>();
        for (char c : peixe.toCharArray()) {
            charList.add(c);
        }
        Collections.shuffle(charList);

        StringBuilder resultado = new StringBuilder();
        for (char c : charList) {
            resultado.append(c);
        }
        return resultado.toString();
    }

    public static boolean isNomeCorreto(String[] listaPeixes, String digitado) {
        for (String item : listaPeixes) {
            if (item.equalsIgnoreCase(digitado)) {
                return true;
            }
        }
        return false;
    }

    public static double calcularPesoPeixe(String peixe, int dificuldade) {
        Random rand = new Random();
        double peso = switch (dificuldade) {
            case 1 -> rand.nextDouble() * 10 + 1;
            case 2 -> rand.nextDouble() * 20 + 5;
            case 3 -> rand.nextDouble() * 30 + 10;
            default -> 0;
        };
        return peso;
    }
}