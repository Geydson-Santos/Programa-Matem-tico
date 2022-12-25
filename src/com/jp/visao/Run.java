/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp.visao;
import com.formdev.flatlaf.FlatLightLaf;
import com.jp.modelos.Tempo;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Woly
 */
public class Run {
    
    private static Tempo timer = null;
    public static TelaPrincipal tela = null;
    public static TelaLogo telaLogo= null;
    
    
    public static void main(String args[]){
        telaLogo = new TelaLogo();
//        ActionListener fecharTelaLogo = (e) -> {
//            //telaLogo.fechar();
//            //proximaLetra();
//        };
        
        //timer = new Tempo(2 * 1000, 0, fecharTelaLogo, null);
        
        //timer.start();
    }
}
