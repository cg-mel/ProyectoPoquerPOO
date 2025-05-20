import java.util.*;
public class HandEvaluator {
    private Card card;
    private static ArrayList<Card> copia;

    public HandEvaluator(ArrayList<Card> cards) {
        copia = new ArrayList<>();
        copia = (ArrayList<Card>) cards.clone();
        copia.sort((carta1, carta2) -> Integer.compare(carta1.getValue(), carta2.getValue()));
    }

    public int evaluateHand(){
        //Collections.sort(copia);
        /*if (esEscaleraReal(copia))
            return 9;//"Escalera Real";*/
        if (esEscaleraDeColor(copia))
            return 8;//"Escalera de Color";
        if (esPoquer(copia))
            return 7;//"Póquer";
        if (esFull(copia))
            return 6;//"Full";
        if (esColor(copia))
            return 5;//"Color";
        if (esEscalera(copia))
            return 4;//"Escalera";
        if (esTrio(copia))
            return 3;//"Trío";
        if (esDoblePar(copia))
            return 2;//"Doble Par";
        if (esPar(copia))
            return 1;//"Par";

        return 0;//"Card Alta";
    }

    /*private static boolean esEscaleraReal(ArrayList<Card> mano) {
        return esEscaleraDeColor(mano) && mano.stream().anyMatch(carta -> carta.getValue().equals(1));
    }*/

    private static boolean esEscaleraDeColor(ArrayList<Card> mano) {
        return esColor(mano) && esEscalera(mano);
    }

    private static boolean esPoquer(ArrayList<Card> mano) {
        return tieneNDelMismoValor(mano, 4);
    }

    private static boolean esFull(ArrayList<Card> mano) {
        HashMap<Integer, Integer> conteo = contarValores(mano);
        return conteo.containsValue(3) && conteo.containsValue(2);
    }

    private static boolean esColor(ArrayList<Card> mano) {
        String palo = mano.getFirst().getSuit();
        for (Card carta : mano) {
            if (!Objects.equals(carta.getSuit(), palo))
                return false;
        }
        return true;
    }

    private static boolean esEscalera(ArrayList<Card> mano) {
        HashSet<Integer> valores = new HashSet<>();
        for (Card carta : mano) {
            valores.add(carta.getValue());
        }

        ArrayList<Integer> listaValores = new ArrayList<>(valores);
        Collections.sort(listaValores);

        if (tieneCincoConsecutivos(listaValores))
            return true;

        if (valores.contains(14)) {
            listaValores.add(1);
            Collections.sort(listaValores);
            if (tieneCincoConsecutivos(listaValores))
                return true;
        }

        return false;
    }

    private static boolean tieneCincoConsecutivos(ArrayList<Integer> valores) {
        int consecutivos = 1;
        for (int i = 1; i < valores.size(); i++) {
            if (valores.get(i) == valores.get(i - 1) + 1) {
                consecutivos++;
                if (consecutivos >= 5)
                    return true;
            } else {
                consecutivos = 1;
            }
        }
        return false;
    }

    private static boolean esTrio(ArrayList<Card> mano) {
        return tieneNDelMismoValor(mano, 3);
    }

    private static boolean esDoblePar(ArrayList<Card> mano) {
        HashMap<Integer, Integer> frecuenciaValores = contarValores(mano);
        return frecuenciaValores.values()
                .stream()
                .filter(cantidad -> cantidad == 2)
                .count() >= 2;
    }

    private static boolean esPar(ArrayList<Card> mano) {
        return tieneNDelMismoValor(mano, 2);
    }

    private static boolean tieneNDelMismoValor(ArrayList<Card> mano, int n) {
        HashMap<Integer, Integer> frecuenciaValores = contarValores(mano);
        return frecuenciaValores.containsValue(n);
    }

    private static HashMap<Integer, Integer> contarValores(ArrayList<Card> mano) {
        HashMap<Integer, Integer> frecuenciaValores = new HashMap<>();
        for (Card carta : mano) {
            int valor = carta.getValue();
            frecuenciaValores.put(valor, frecuenciaValores.getOrDefault(valor, 0) + 1);
        }
        return frecuenciaValores;
    }
}
