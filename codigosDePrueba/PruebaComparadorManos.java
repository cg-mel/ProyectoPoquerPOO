package com.mycompany.proyectopoquer;

import java.util.ArrayList;
import java.util.Arrays;

public class PruebaComparadorManos {
    public static void main(String[] args) {
        ArrayList<Carta> mano1 = new ArrayList<>(Arrays.asList(
            new Carta("7", '♣'), new Carta("7", '♢'), new Carta("K", '♡'),
            new Carta("3", '♠'), new Carta("2", '♣') //par
        ));

        ArrayList<Carta> mano2 = new ArrayList<>(Arrays.asList(
            new Carta("2", '♡'), new Carta("5", '♡'), new Carta("8", '♡'),
            new Carta("J", '♡'), new Carta("A", '♡') //color
        ));
        
        ArrayList<Carta> mano3 = new ArrayList<>(Arrays.asList(
            new Carta("3", '♣'), new Carta("3", '♢'), new Carta("3", '♡'),
            new Carta("3", '♠'), new Carta("A", '♡') //poquer
        ));

        JugadorPrueba jugador1 = new JugadorPrueba("Alice", mano1);
        JugadorPrueba jugador2 = new JugadorPrueba("Bob", mano2);
        JugadorPrueba jugador3 = new JugadorPrueba("Bella", mano3);

        ArrayList<JugadorPrueba> jugadores = new ArrayList<>(Arrays.asList(jugador1, jugador2, jugador3));
        JugadorPrueba ganador = ComparadorDeManos.encontrarGanador(jugadores);

        System.out.println("El ganador es: " + ganador.getNombre());
        System.out.println("Con la mano: " + EvaluadorPrueba.evaluarMano(ganador.getMano()));
    }
}