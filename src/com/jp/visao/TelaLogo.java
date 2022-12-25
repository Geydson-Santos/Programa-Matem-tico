/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp.visao;

/**
 *
 * @author aluno
 */
import com.formdev.flatlaf.FlatLightLaf;
import com.jp.modelos.Tempo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TelaLogo {
    
    JWindow jWindow = new JWindow();
    JLabel bemVindo = new JLabel();
    
    private static Tempo timer = null;
    
    private String frase = "Seja Bem-Vindo ao Programa Matemático!";
    private char letras[] = frase.toCharArray();
    private int cont = 0;
    
    public TelaLogo() {
        
        ActionListener acaoDeRepeticao = (e) -> {
            proximaLetra();
        };
        
        
        ActionListener abrirTelaPrincipal = (e) -> {
            try {
                Thread.sleep(1000);
            } catch (Exception erro) {
                erro.printStackTrace();
            }
            Run.telaLogo.fechar();
            if(!FlatLightLaf.setup()) JOptionPane.showMessageDialog(null, "Falha ao importar o Tema.");
            Run.tela = new TelaPrincipal();
            Run.tela.setVisible(true);
        };
        
        timer = new Tempo(100, letras.length, acaoDeRepeticao, abrirTelaPrincipal);
        timer.start();
        
        jWindow.setBackground(new Color(0, 0, 0, 0));
        jWindow.setContentPane(new Pane());
        jWindow.pack();
        jWindow.setLocationRelativeTo(null);
        jWindow.setVisible(true);
    }
    
    private void proximaLetra(){
        String texto = "";
        //if(cont == 38) cont--;
        for(int i = 0; i <= cont; i++){
            texto += letras[i];
        }
        cont++;
        bemVindo.setText(texto);
        jWindow.setSize(bemVindo.getWidth() + 30, bemVindo.getHeight() + 10);
        jWindow.setLocationRelativeTo(null);
    }
    
    public void fechar(){
        jWindow.dispose();
    }

    class Pane extends JPanel {

        //private BufferedImage leaf;
        
        Font montSerrat = null;
        
        Border bordaPreta = new LineBorder(Color.BLACK, 2, true);

        public Pane() {
            setBorder(new EmptyBorder(0, 0, 0, 0));
            File fonte = new File("./src/com/jp/fonts/Montserrat-SemiBold.ttf");
            if(!fonte.exists()) fonte = new File(System.getProperty("user.dir") + "/fonts/Montserrat-SemiBold.ttf");
            try {
                montSerrat = Font.createFont(Font.TRUETYPE_FONT, fonte);
                montSerrat = montSerrat.deriveFont(48.0f);
                fonte.deleteOnExit();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            bemVindo.setFont(montSerrat); // NOI18N
            bemVindo.setForeground(Color.GREEN);
            //bemVindo.setText("Seja Bem-Vindo ao Programa Matemático!");
            //bemVindo.setForeground(Color.WHITE);
            //bemVindo.setBorder(bordaPreta);
            //bemVindo.setSize(500, 500);

//            try {
//                leaf = ImageIO.read(getClass().getResource("/com/jp1/icones/JP_Softwares.png"));
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
            setOpaque(false);
            setLayout(new GridBagLayout());
            initComponents();
        }
        
        public void initComponents(){
            //add(bemVindo);
            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this);
            setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(bemVindo, -1, -1, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(bemVindo, -1, -1, Short.MAX_VALUE))
            );
        }

//        @Override
//        public Dimension getPreferredSize() {
//            return bemVindo == null ? new Dimension(200, 200) : new Dimension(bemVindo.getWidth(), bemVindo.getHeight());
//        }

//        @Override
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            if (bemVindo != null) {
//                Graphics2D g2d = (Graphics2D) g.create();
//                bemVindo.setVisible(true);
//                //g2d.dr
//                g2d.dispose();
//            }
//        }
    }
}
