/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp.modelos;

import java.util.Random;

/**
 *
 * @author Woly
 */
public class Expressao {
    
    private final char vezes = '×', divisao = '÷', soma = '+', menos = '-';
    private int n1 = 0, n2 = 0;
    private char operacao = ' ';
    private Random randomico = new Random();

    public Expressao() {
        n1 = randomico.nextInt(11);
        n2 = randomico.nextInt(11);
        switch(randomico.nextInt(4) + 1){
            case 1:
                operacao = vezes;
                break;
            case 2:
                operacao = divisao;
                break;
            case 3:
                operacao = soma;
                break;
            case 4:
                operacao = menos;
                break;
        }
        
        if(operacao == divisao){
            if(n2 == 0) n2++;
            while(n1 / n2 != n1 / (double) (n2)){
                n1 = randomico.nextInt(8) + 2;
                n2 = randomico.nextInt(10) + 1;
            }
        }
    }
    
    public String getExpressao(){
        return n1 + " " + operacao + " " + n2;
    }
    
    public boolean resolverExpressao(int resposta){
        switch(operacao){
            case vezes:
                if(resposta == n1 * n2) return true;
                return false;
            case divisao:
                if(resposta == n1 / n2) return true;
                return false;
            case soma:
                if(resposta == n1 + n2) return true;
                return false;
            case menos:
                if(resposta == n1 - n2) return true;
                return false;
        }
        return false;
    }
    
}
