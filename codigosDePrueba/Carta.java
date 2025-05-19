package com.mycompany.proyectopoquer;

public class Carta {
    private String valor;
    private char palo;

    public Carta(String valor, char palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public String getValor() {
        return valor;
    }

    public char getPalo() {
        return palo;
    }

    public int getValorNumerico() {
        return switch (valor) {
            case "A" -> 14;
            case "K" -> 13;
            case "Q" -> 12;
            case "J" -> 11;
            default -> Integer.parseInt(valor);
        };
    }

    @Override
    public String toString() {
        return valor + palo;
    }
}
