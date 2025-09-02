package com.mycompany.proyectopoquer;

import java.util.ArrayList;

public class JugadorPrueba {
    private final String nombre;
    private final ArrayList<Carta> mano;

    public JugadorPrueba(String nombre, ArrayList<Carta> mano) {
        this.nombre = nombre;
        this.mano = mano;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }
}