package Ventanas;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VentanaPrincipal extends javax.swing.JFrame {
    private boolean matriz[][] = new boolean[3][3]; // Para evitar que se puede clickear mas de 1 vez el mismo boton.
    private String turno = "turnoBoca";
    private int matrizGanador[][] = new int[3][3];
    private String usuario1, usuario2;
    private int contBoca=0, contRiver=0,contEmpates=0;
    
    public VentanaPrincipal(String usuario1, String usuario2) {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        
        initComponents();
        setSize(600,600);
        setLocationRelativeTo(null);
        llenarMatriz();
        llenarMatrizGanador();
    }
    
    private void llenarMatriz(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                matriz[i][j]=true;
            }
        }
    }
    
    private void llenarMatrizGanador(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                matrizGanador[i][j]=0;
            }
        }
    }
    
    private void verificarMatriz(boolean m[][], int i, int j, JButton boton){ // Metodo para agregar los escudos al boton seleccionado.
        if(matriz[i][j]==true){ // Verifico si la celda no está ocupada.
            if(turno.equals("turnoBoca")){ // Verifico de quien es el turno.
                dibujarBoca(boton);
                matrizGanador[i][j] = 1;
                turno="turnoRiver";
            } else {
                dibujarRiver(boton);
                matrizGanador[i][j] = 2;
                turno="turnoBoca";
            }
            matriz[i][j] = false;
            verificarMatrizGanador();
        }
    }
    
    private void verificarMatrizGanador(){
        boolean ganadorBoca = false;
        boolean ganadorRiver = false; // Esto sobra?
        int cont = 0;
        
        if(verificarGanador(1)){
            VentanaGanadorBoca ventanaGB = new VentanaGanadorBoca(this, true, usuario1);
            ventanaGB.setVisible(true);
            contBoca++;
            reiniciarJuego();
        } else if(verificarGanador(2)){
            VentanaGanadorRiver ventanaGR = new VentanaGanadorRiver(this, true, usuario2);
            ventanaGR.setVisible(true);
            contRiver++;
            reiniciarJuego();
        } else {
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(matrizGanador[i][j]!=0){
                        cont++;
                    }
                }
            }
            
            if(cont==9){
                VentanaEmpate ventanaE = new VentanaEmpate(this,true);
                ventanaE.setVisible(true);
                contEmpates++;
                reiniciarJuego();
            } else {
                cont = 0;
            }
        }
    }
    
    private boolean verificarGanador(int num){
        boolean ganador = false;
        for(int i=0; i<3; i++){
            if(matrizGanador[i][0]==num && matrizGanador[i][1]==num && matrizGanador[i][2]==num){ // Verifico por filas.
                ganador=true;
                break;
            } else if(matrizGanador[0][0]==num && matrizGanador[1][1]==num && matrizGanador[2][2]==num){ // Verifico por diagonal.
                ganador=true;
                break;
            } else if(matrizGanador[2][0]==num && matrizGanador[1][1]==num && matrizGanador[0][2]==num){ // Verifico por la otra diagonal.
                ganador=true;
                break;
            } else if(matrizGanador[0][i]==num && matrizGanador[1][i]==num && matrizGanador[2][i]==num){ // Verifico por columna.
                ganador=true;
                break;
            }
        }
        
        return ganador;
    }
    
    private void reiniciarJuego(){
        llenarMatriz(); // Reinicio matriz booleana.
        llenarMatrizGanador(); // Reinicio matriz de 1 y 2.
        
        boton00.setIcon(null); // Saco los iconos de los botones.
        boton01.setIcon(null);
        boton02.setIcon(null);
        boton10.setIcon(null);
        boton11.setIcon(null);
        boton12.setIcon(null);
        boton20.setIcon(null);
        boton21.setIcon(null);
        boton22.setIcon(null);
        
        quienEmpieza();
    }
    
    private void quienEmpieza(){
        VentanaTurno ventanaT = new VentanaTurno(this,true,usuario1,usuario2);
        ventanaT.setVisible(true);
        
        turno = ventanaT.getTurno();
    }
    
    private void dibujarBoca(JButton boton){
        boton.setIcon(new ImageIcon(getClass().getResource("/Img/bocaJrs.png")));
    }
    
    private void dibujarRiver(JButton boton){
        boton.setIcon(new ImageIcon(getClass().getResource("/Img/riverPlate.png")));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        boton00 = new javax.swing.JButton();
        boton01 = new javax.swing.JButton();
        boton02 = new javax.swing.JButton();
        boton10 = new javax.swing.JButton();
        boton11 = new javax.swing.JButton();
        boton12 = new javax.swing.JButton();
        boton20 = new javax.swing.JButton();
        boton21 = new javax.swing.JButton();
        boton22 = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        menuJuego = new javax.swing.JMenu();
        menuReiniciar = new javax.swing.JMenuItem();
        menuEstadisticas = new javax.swing.JMenuItem();
        separador = new javax.swing.JPopupMenu.Separator();
        menuSalir = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setLayout(new java.awt.GridLayout(3, 3));

        boton00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton00ActionPerformed(evt);
            }
        });
        panel.add(boton00);

        boton01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton01ActionPerformed(evt);
            }
        });
        panel.add(boton01);

        boton02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton02ActionPerformed(evt);
            }
        });
        panel.add(boton02);

        boton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton10ActionPerformed(evt);
            }
        });
        panel.add(boton10);

        boton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton11ActionPerformed(evt);
            }
        });
        panel.add(boton11);

        boton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton12ActionPerformed(evt);
            }
        });
        panel.add(boton12);

        boton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton20ActionPerformed(evt);
            }
        });
        panel.add(boton20);

        boton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton21ActionPerformed(evt);
            }
        });
        panel.add(boton21);

        boton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton22ActionPerformed(evt);
            }
        });
        panel.add(boton22);

        menuJuego.setText("Juego");
        menuJuego.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        menuReiniciar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reiniciar.png"))); // NOI18N
        menuReiniciar.setText("Reiniciar");
        menuReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReiniciarActionPerformed(evt);
            }
        });
        menuJuego.add(menuReiniciar);

        menuEstadisticas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/estadisticas.png"))); // NOI18N
        menuEstadisticas.setText("Estadisticas");
        menuEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEstadisticasActionPerformed(evt);
            }
        });
        menuJuego.add(menuEstadisticas);
        menuJuego.add(separador);

        menuSalir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/salir.png"))); // NOI18N
        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        menuJuego.add(menuSalir);

        barraMenu.add(menuJuego);

        menuAyuda.setText("Ayuda");
        menuAyuda.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        menuAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAyudaMouseClicked(evt);
            }
        });
        menuAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAyudaActionPerformed(evt);
            }
        });
        barraMenu.add(menuAyuda);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void boton00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton00ActionPerformed
        verificarMatriz(matriz,0,0,boton00);
    }//GEN-LAST:event_boton00ActionPerformed

    private void boton01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton01ActionPerformed
        verificarMatriz(matriz,0,1,boton01);
    }//GEN-LAST:event_boton01ActionPerformed

    private void boton02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton02ActionPerformed
        verificarMatriz(matriz,0,2,boton02);
    }//GEN-LAST:event_boton02ActionPerformed

    private void boton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton10ActionPerformed
        verificarMatriz(matriz,1,0,boton10);
    }//GEN-LAST:event_boton10ActionPerformed

    private void boton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton11ActionPerformed
        verificarMatriz(matriz,1,1,boton11);
    }//GEN-LAST:event_boton11ActionPerformed

    private void boton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton12ActionPerformed
        verificarMatriz(matriz,1,2,boton12);
    }//GEN-LAST:event_boton12ActionPerformed

    private void boton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton20ActionPerformed
        verificarMatriz(matriz,2,0,boton20);
    }//GEN-LAST:event_boton20ActionPerformed

    private void boton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton21ActionPerformed
        verificarMatriz(matriz,2,1,boton21);
    }//GEN-LAST:event_boton21ActionPerformed

    private void boton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton22ActionPerformed
        verificarMatriz(matriz,2,2,boton22);
    }//GEN-LAST:event_boton22ActionPerformed

    private void menuEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEstadisticasActionPerformed
        VentanaEstadisticas ventanaE = new VentanaEstadisticas(this,true,usuario1,usuario2,contBoca,contRiver,contEmpates);
        ventanaE.setVisible(true);
    }//GEN-LAST:event_menuEstadisticasActionPerformed

    private void menuReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReiniciarActionPerformed
        contBoca=0; 
        contRiver=0;
        contEmpates=0;
        reiniciarJuego();
    }//GEN-LAST:event_menuReiniciarActionPerformed

    private void menuAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAyudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuAyudaActionPerformed

    private void menuAyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAyudaMouseClicked
        try {
            try {
                Desktop.getDesktop().browse(new URI("https://es.wikipedia.org/wiki/Tres_en_l%C3%ADnea"));
            } catch (IOException ex) {
                
            }
        } catch (URISyntaxException ex) {
            
        }
    }//GEN-LAST:event_menuAyudaMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal(null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton boton00;
    private javax.swing.JButton boton01;
    private javax.swing.JButton boton02;
    private javax.swing.JButton boton10;
    private javax.swing.JButton boton11;
    private javax.swing.JButton boton12;
    private javax.swing.JButton boton20;
    private javax.swing.JButton boton21;
    private javax.swing.JButton boton22;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenuItem menuEstadisticas;
    private javax.swing.JMenu menuJuego;
    private javax.swing.JMenuItem menuReiniciar;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JPanel panel;
    private javax.swing.JPopupMenu.Separator separador;
    // End of variables declaration//GEN-END:variables
}
