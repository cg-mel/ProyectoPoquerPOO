package com.mycompany.proyectopoquer;

import java.util.ArrayList;
import java.util.Arrays;

public class ComparadorDeManos {
    private static final ArrayList<String> ranking = new ArrayList<>(Arrays.asList(
        "Escalera Real", "Escalera de Color", "Póquer", "Full", "Color",
        "Escalera", "Trío", "Doble Par", "Par", "Carta Alta"
    ));

    public static JugadorPrueba encontrarGanador(ArrayList<JugadorPrueba> jugadores) {
        JugadorPrueba mejor = jugadores.get(0);
        String mejorMano = EvaluadorPrueba.evaluarMano(mejor.getMano());

        for (int i = 1; i < jugadores.size(); i++) {
            JugadorPrueba actual = jugadores.get(i);
            String manoActual = EvaluadorPrueba.evaluarMano(actual.getMano());

            if (compararManos(manoActual, mejorMano) > 0) {
                mejor = actual;
                mejorMano = manoActual;
            }
        }

        return mejor;
    }

    private static int compararManos(String mano1, String mano2) {
        return Integer.compare(ranking.indexOf(mano2), ranking.indexOf(mano1));
    }
}
