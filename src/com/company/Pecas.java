package com.company;

import java.util.Random;

public class Pecas {
    public int x;
    public int y;

    //VAO RECEBER VALORES ALEATORIOS DE 0 A 9
    public Pecas() {
        Random aleatorio = new Random();
        this.x = aleatorio.nextInt(10);
        this.y = aleatorio.nextInt(10);

    }
}
