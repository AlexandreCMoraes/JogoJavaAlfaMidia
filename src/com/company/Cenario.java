package com.company;

public class Cenario {
    int [][] mapa;
    String [] desenhos;
    Pecas[] inimigos;
    int pecasRestantes;
    int tirosRestantes;

    public Cenario() {
        this.pecasRestantes = 5;
        this.tirosRestantes = 25;
        this.mapa = new int[10][10];
        //MONTA SOMENTE UMA LINHA (ANTES DA FUNÇÃO 'desenhaCenario')
        //this.desenhaLinha(this.mapa[0]);
        //PREPARA OS ARRAYS A RECEBER/SUBSTITUIR ICONES 0=., x=1, 2=*
        //this.mapa[1][1] = 1;
        //this.mapa[2][2] = 2;
        //INFORMA O ARRAY COM NOVOS ICONES 0=., x=1, 2=*
        this.desenhos = new String[]{".", "X", "*"};
        //this.inimigos = new Pecas[5];
        this.inimigos = new Pecas[this.pecasRestantes];

        for (int i = 0; i < pecasRestantes; i++) {
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

        System.out.println(("Peças restantes: " + this.pecasRestantes));
        System.out.println(("Tiros restantes: " + this.tirosRestantes));


        //for(int i = 0; i < 5; i++){
          //  System.out.println((i + 1) + "(" + this.inimigos[i].x + "," + this.inimigos[i].y + ")");
       // }

    }

    public boolean disparo(int x, int y){
        this.tirosRestantes--;
        double distancia = 100;
        double d1 = 0;

        //PARA CADA PECAS DO ARRAY DE INIMIGOS E CALCULAR A DISTANCIA
        for(Pecas p: inimigos){
            //SOMENTE SE ESTIVER VIVO, FAZ O CALCULO
            if(p.isVivo()) {
                //A PECA SERA RESPONSAVEL EM RETORNAR A DISTANCIA EM RELACAO AO DISPARO
                d1 = p.disparo(x, y);
                //DELETAR A PECA ATINGIDA MESMO SE TIVER DUAS NO MESMO LUGAR
                if(d1 ==0){
                    this.pecasRestantes--;
                }
                distancia = (d1 < distancia) ? d1 : distancia;
            // if(d1 < distancia){
                //distancia = d1;
                // }
            }
        }
        System.out.println("=====================================");
        System.out.println("Distância é: " + distancia);
        System.out.println("=====================================");
        //DELETAR A PECA ATINGIDA, MAS PODE OCORRER DE DUAS NO MESMO LUGAR
        //if(distancia ==0){
         //   this.pecasRestantes--;
        //}

        //X NA HORIZONTAL E Y VERTICAL
        //this.mapa[y][x] = 1;
        this.mapa[y][x] = (distancia > 0)?1:2;

        return ((this.pecasRestantes > 0) && (this.tirosRestantes > 0));
    }

}
