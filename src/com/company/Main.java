package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    //
        boolean continuarPartida = true;

        //LER INFO DA DIGITAÇÃO
        Scanner scanner = new Scanner(System.in);
        String entrada;
        //CHAMANDO A INSTANCIA MAPA
        Cenario mapa = new Cenario();


        while (continuarPartida){
            System.out.println("Entre com as posições x e y no formato x,y: ");
            entrada = scanner.nextLine();
            //DEFINE A QUEBRA DA STRING COLOCANDO O PRIMEIRO NO X E DEPOIS NO Y NESSE ARRAY DE STRING COM ','
            String[] numeros = entrada.split(",");
            int x = Integer.parseInt(numeros[0]);
            int y = Integer.parseInt(numeros[1]);
            System.out.println(("x = " + x + ", e y = " + y));
            //ENQUANTO NAO FOR DIGITADO FIM, O PROGRAMA CONTINUA RODANDO
            if(entrada.equals("FIM")) break;
            mapa.disparo(x,y);
            mapa.desenhaCenario();
        }
    }
}
