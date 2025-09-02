package com.mycompany.proyectopoquer;

import java.util.*;

public class PruebaEvaluador {
    public static void main(String[] args) {
        ArrayList<Carta> mano = new ArrayList<>(Arrays.asList(
            new Carta("10", '♡'),
            new Carta("J", '♡'),
            new Carta("Q", '♡'),
            new Carta("K", '♡'),
            new Carta("A", '♡')
        ));

        System.out.println(EvaluadorPrueba.evaluarMano(mano)); //escalera real
    }
}