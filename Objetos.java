public class Objetos {
    // Método para gerar os nomes dos objetos
    public static String[] gerarObjetos() {
        // Lista de objetos que podem ser pescados
        return new String[] {
            "Lata de refrigerante",
            "Bota velha",
            "Plástico",
            "Pneu",
            "Garrafa quebrada"
        };
    }

    // Método para retornar mensagens correspondentes ao objeto pescado
    public static String mensagemParaObjeto(String objeto) {
        switch (objeto) {
            case "Lata de refrigerante":
                return "Você pescou uma lata de refrigerante! O oceano agradece por limpá-lo. - Você perdeu uma isca";
            case "Bota velha":
                return "Você pescou uma bota velha! Quem será que perdeu isso? - Você perdeu uma isca";
            case "Plástico":
                return "Você pescou um pedaço de plástico. Menos poluição no mar! - Você perdeu uma isca";
            case "Pneu":
                return "Você pescou um pneu. Parece que era parte de um carro afundado! - Você perdeu uma isca";
            case "Garrafa quebrada":
                return "Você pescou uma garrafa quebrada. Cuidado com os cacos! - Você perdeu uma isca";
            default:
                return "Objeto desconhecido. Algo inesperado foi pescado! - Você perdeu uma isca";
        }
    }
}
 