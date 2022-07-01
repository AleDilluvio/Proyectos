package Ventanas;

import javax.swing.ImageIcon;

public class VentanaInicial extends javax.swing.JFrame {
    private String usuarioBoca;
    private String usuarioRiver;
    
    public VentanaInicial() {
        setSize(600,420);
        setLocationRelativeTo(null);
        initComponents();
        botonEmpezar.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        etiquetaTitulo = new javax.swing.JLabel();
        etiquetaBoca = new javax.swing.JLabel();
        etiquetaRiver = new javax.swing.JLabel();
        textoBoca = new javax.swing.JTextField();
        textoRiver = new javax.swing.JTextField();
        gifTaTeTi = new javax.swing.JLabel();
        botonGuardarDatos = new javax.swing.JButton();
        etiquetaMuestraBoca = new javax.swing.JLabel();
        etiquetaMuestraRiver = new javax.swing.JLabel();
        botonEmpezar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(600, 400));
        panel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelKeyPressed(evt);
            }
        });
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiquetaTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        etiquetaTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTitulo.setText("Ta Te Ti");
        panel.add(etiquetaTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 32, 600, -1));

        etiquetaBoca.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etiquetaBoca.setText("Digite el nombre del usario de Boca:");
        panel.add(etiquetaBoca, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 90, -1, -1));

        etiquetaRiver.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etiquetaRiver.setText("Digite el nombre del usuario de River:");
        panel.add(etiquetaRiver, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 148, -1, -1));

        textoBoca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        textoBoca.setPreferredSize(new java.awt.Dimension(64, 28));
        textoBoca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoBocaActionPerformed(evt);
            }
        });
        panel.add(textoBoca, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 89, 200, -1));

        textoRiver.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        textoRiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoRiverActionPerformed(evt);
            }
        });
        panel.add(textoRiver, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 147, 200, 28));

        gifTaTeTi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/gif.gif"))); // NOI18N
        panel.add(gifTaTeTi, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 205, -1, -1));

        botonGuardarDatos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        botonGuardarDatos.setText("Guardar");
        botonGuardarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarDatosActionPerformed(evt);
            }
        });
        botonGuardarDatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonGuardarDatosKeyPressed(evt);
            }
        });
        panel.add(botonGuardarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 230, -1, -1));

        etiquetaMuestraBoca.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        panel.add(etiquetaMuestraBoca, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 271, -1, -1));

        etiquetaMuestraRiver.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        panel.add(etiquetaMuestraRiver, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 294, -1, -1));

        botonEmpezar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        botonEmpezar.setText("Empezar!");
        botonEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEmpezarActionPerformed(evt);
            }
        });
        panel.add(botonEmpezar, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 343, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoBocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoBocaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoBocaActionPerformed

    private void textoRiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoRiverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoRiverActionPerformed

    private void botonGuardarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarDatosActionPerformed
        usuarioBoca = textoBoca.getText();
        usuarioRiver = textoRiver.getText();
        
        botonGuardarDatos.setVisible(false);
        botonEmpezar.setVisible(true);
        
        etiquetaMuestraBoca.setText(usuarioBoca+", empieza.");
        etiquetaMuestraRiver.setText(usuarioRiver+", va segundo.");
        
    }//GEN-LAST:event_botonGuardarDatosActionPerformed

    private void botonEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEmpezarActionPerformed
        VentanaPrincipal ventanaP = new VentanaPrincipal(usuarioBoca,usuarioRiver);
        ventanaP.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonEmpezarActionPerformed

    private void botonGuardarDatosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonGuardarDatosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGuardarDatosKeyPressed

    private void panelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelKeyPressed

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
            java.util.logging.Logger.getLogger(VentanaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEmpezar;
    private javax.swing.JButton botonGuardarDatos;
    private javax.swing.JLabel etiquetaBoca;
    private javax.swing.JLabel etiquetaMuestraBoca;
    private javax.swing.JLabel etiquetaMuestraRiver;
    private javax.swing.JLabel etiquetaRiver;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JLabel gifTaTeTi;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField textoBoca;
    private javax.swing.JTextField textoRiver;
    // End of variables declaration//GEN-END:variables
}
