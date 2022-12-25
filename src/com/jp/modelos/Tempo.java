/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp.modelos;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Woly
 */
public class Tempo extends Timer {
    
    private int cont = 0;
    
    public ActionListener agir(int repeticoes, ActionListener acaoDeRepeticao, ActionListener acaoFinal){
        ActionListener acao = (e) -> {
            if(cont == repeticoes){
                if(acaoFinal != null) acaoFinal.actionPerformed(null);
                this.stop();
            }else{
                if(acaoDeRepeticao != null) acaoDeRepeticao.actionPerformed(null);
            }
            cont++;
        };
        
        return acao;
    }

    public Tempo(int delay, int repeticoes, ActionListener acaoDeRepeticao, ActionListener acaoFinal) {
        super(delay, null);
        
        super.addActionListener(agir(repeticoes, acaoDeRepeticao, acaoFinal));
    };

    public int getCont() {
        return cont;
    }
}
