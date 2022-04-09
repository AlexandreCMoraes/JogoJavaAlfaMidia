package com.company;

import java.util.Random;

public class Pecas {
    //public int x;
    //public int y;

    private int x;
    private int y;

    //SOMENTE PARA INFORMAR SE VIVO OU NAO
    public boolean isVivo() {
        return vivo;
    }

    //CONTROLE DE PECAS ATIVAS OU NAO
    private boolean vivo;


    //VAO RECEBER VALORES ALEATORIOS DE 0 A 9
    public Pecas() {
        Random aleatorio = new Random();
        this.x = aleatorio.nextInt(10);
        this.y = aleatorio.nextInt(10);

        this.vivo = true;

    }

    //DEFINIR A DISTANCIA DOS DISPAROS
    public double disparo (int x, int y){
        //FORMULA DE RAIZ QUADRADA PARA SABER A DISTANCIA
        double distancia = Math.sqrt((x-this.x) * (x-this.x) + (y-this.y) * (y-this.y));
        //DEIXA DE ESTAR VIVO
        if(distancia == 0) this.vivo = false;
        //RETORNA SOMENTE A DISTANCIA
        return distancia;
    }
}
