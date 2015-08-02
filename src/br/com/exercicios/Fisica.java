package br.com.exercicios;

/**
 * Created by felipe on 02/08/15.
 */
public class Fisica {
    private double velocidadeInicial;
    private double posicaoInicial;
    private int tempo;
    private double aceleracao;
    private double massa;


    /*
    Consultas de respostas

    www.webcalc.com.br/frame.asp?pag=http://www.webcalc.com.br/ciencias/cinematica.html
     */
    
    /*
    O espaço final de um determinado ponto material(MU).
    */
    public double espacoFInalUniforme(double posicaoInicial,double velocidadeInicial,int tempo){

        double resultado = 0;
        //calculo
        resultado = posicaoInicial + (velocidadeInicial * tempo);
        return resultado;
    }

    public double velocidadeFinal(double velocidadeInicial,double aceleracao,int tempo){
        double resultado = 0;

        resultado = velocidadeInicial +(aceleracao * tempo);

        return resultado;
    }

    public double espacoFinalVariado(double posicaoInicial,double velocidadeInicial,double aceleracao,int tempo){
        double resultado = 0;

        resultado = posicaoInicial + (velocidadeInicial * tempo) + (0.5*(aceleracao*Math.pow(tempo,2)));
        return resultado;
    }

    public double energiaCinetica(double massa,double velocidadeInicial){
        double resultado = 0;

        resultado = 0.5 *(massa*(Math.pow(velocidadeInicial,2)));

        return resultado;
    }
    public double getVelocidadeInicial() {
        return velocidadeInicial;
    }

    public void setVelocidadeInicial(double velocidadeInicial) {
        this.velocidadeInicial = velocidadeInicial;
    }

    public double getPosicaoInicial() {
        return posicaoInicial;
    }

    public void setPosicaoInicial(double posicaoInicial) {
        this.posicaoInicial = posicaoInicial;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public double getAceleracao() {
        return aceleracao;
    }

    public void setAceleracao(double aceleracao) {
        this.aceleracao = aceleracao;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }
}


