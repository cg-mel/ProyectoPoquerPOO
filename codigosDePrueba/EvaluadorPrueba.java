package com.mycompany.proyectopoquer;

import java.util.*;

public class EvaluadorPrueba {

    public static String evaluarMano(ArrayList<Carta> mano) {
        if (mano.size() < 5) {
            return "Se requieren al menos 5 cartas para evaluar una mano.";
        }

        ArrayList<Carta> copia = new ArrayList<>(mano);
        copia.sort((carta1, carta2) -> Integer.compare(carta1.getValorNumerico(), carta2.getValorNumerico()));

        if (esEscaleraReal(copia)) 
            return "Escalera Real";
        if (esEscaleraDeColor(copia)) 
            return "Escalera de Color";
        if (esPoquer(copia)) 
            return "Póquer";
        if (esFull(copia)) 
            return "Full";
        if (esColor(copia)) 
            return "Color";
        if (esEscalera(copia)) 
            return "Escalera";
        if (esTrio(copia)) 
            return "Trío";
        if (esDoblePar(copia)) 
            return "Doble Par";
        if (esPar(copia)) 
            return "Par";

        return "Carta Alta";
    }

    private static boolean esEscaleraReal(ArrayList<Carta> mano) {
        return esEscaleraDeColor(mano) && mano.stream().anyMatch(carta -> carta.getValor().equals("A"));
    }

    private static boolean esEscaleraDeColor(ArrayList<Carta> mano) {
        return esColor(mano) && esEscalera(mano);
    }

    private static boolean esPoquer(ArrayList<Carta> mano) {
        return tieneNDelMismoValor(mano, 4);
    }

    private static boolean esFull(ArrayList<Carta> mano) {
        HashMap<Integer, Integer> conteo = contarValores(mano);
        return conteo.containsValue(3) && conteo.containsValue(2);
    }

    private static boolean esColor(ArrayList<Carta> mano) {
        char palo = mano.get(0).getPalo();
        for (Carta carta : mano) {
            if (carta.getPalo() != palo) 
                return false;
        }
        return true;
    }

    private static boolean esEscalera(ArrayList<Carta> mano) {
        HashSet<Integer> valores = new HashSet<>();
        for (Carta carta : mano) {
            valores.add(carta.getValorNumerico());
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

    private static boolean esTrio(ArrayList<Carta> mano) {
        return tieneNDelMismoValor(mano, 3);
    }

    private static boolean esDoblePar(ArrayList<Carta> mano) {
        HashMap<Integer, Integer> frecuenciaValores = contarValores(mano);
        return frecuenciaValores.values()
                                .stream()
                                .filter(cantidad -> cantidad == 2)
                                .count() >= 2;
    }

    private static boolean esPar(ArrayList<Carta> mano) {
        return tieneNDelMismoValor(mano, 2);
    }

    private static boolean tieneNDelMismoValor(ArrayList<Carta> mano, int n) {
        HashMap<Integer, Integer> frecuenciaValores = contarValores(mano);
        return frecuenciaValores.containsValue(n);
    }

    private static HashMap<Integer, Integer> contarValores(ArrayList<Carta> mano) {
        HashMap<Integer, Integer> frecuenciaValores = new HashMap<>();
        for (Carta carta : mano) {
            int valor = carta.getValorNumerico();
            frecuenciaValores.put(valor, frecuenciaValores.getOrDefault(valor, 0) + 1);
        }
        return frecuenciaValores;
    }
}
