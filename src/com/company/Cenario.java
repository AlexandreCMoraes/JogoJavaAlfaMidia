package com.company;

public class Cenario {
    int [][] mapa;
    String [] desenhos;
    Pecas[] inimigos;

    public Cenario() {
        this.mapa = new int[10][10];
        //MONTA SOMENTE UMA LINHA (ANTES DA FUNÇÃO 'desenhaCenario')
        //this.desenhaLinha(this.mapa[0]);
        //PREPARA OS ARRAYS A RECEBER/SUBSTITUIR ICONES 0=., x=1, 2=*
        this.mapa[1][1] = 1;
        this.mapa[2][2] = 2;
        //INFORMA O ARRAY COM NOVOS ICONES 0=., x=1, 2=*
        this.desenhos = new String[]{".", "X", "*"};
        this.inimigos = new Pecas[5];
        for (int i = 0; i < 5; i++) {
            this.inimigos[i] = new Pecas();
        }
    }
    public void desenhaLinha(int[] linha){
        String strLinha = "";
        //CELULA SERA CADA ELEMENTO DO INT
        for (int celula: linha){
            //NAO SERA MAIS A CELULA COM UMA LINHA QUE FAZIA ABAIXO
            //strLinha += celula;
            //AGORA A PARECE '.' NO LUGAR DE '0',
            strLinha += this.desenhos[celula] + " ";
        }
        System.out.println(strLinha);
    }

        //PERCORRER OS ARRAYS FORMANDO  LINHAS E COLUNAS
    public void desenhaCenario(){
        for(int[] linha : this.mapa){
            this.desenhaLinha(linha);
        }

        for(int i = 0; i < 5; i++){
            System.out.println((i + 1) + "(" + this.inimigos[i].x + "," + this.inimigos[i].y + ")");
        }
    }

    public void disparo(int x, int y){
        //X NA HORIZONTAL E Y VERTICAL
        this.mapa[y][x] = 1;

    }

}
