/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gui.logindanregist;

import static com.gui.logindanregist.register.nama;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class menu extends javax.swing.JFrame {

    /**
     * Creates new form menu
     */
    int confirm;
    
    public menu() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuutama = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        profilmenu = new javax.swing.JMenuItem();
        logoutmenu = new javax.swing.JMenuItem();
        keluarmenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuBar1.setBackground(new java.awt.Color(204, 0, 0));
        jMenuBar1.setForeground(new java.awt.Color(204, 0, 0));

        jMenu1.setText("Menu");

        menuutama.setText("menu utama");
        menuutama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuutamaActionPerformed(evt);
            }
        });
        jMenu1.add(menuutama);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("profil");

        profilmenu.setText("profil");
        profilmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilmenuActionPerformed(evt);
            }
        });
        jMenu2.add(profilmenu);

        logoutmenu.setText("logout");
        logoutmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutmenuActionPerformed(evt);
            }
        });
        jMenu2.add(logoutmenu);

        keluarmenu.setText("keluar");
        keluarmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarmenuActionPerformed(evt);
            }
        });
        jMenu2.add(keluarmenu);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuutamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuutamaActionPerformed
        // TODO add your handling code here:
        dispose();
        
        utama fromInput = new utama();
        fromInput.setVisible(true);
        fromInput.setLocationRelativeTo(null);
        
     
    }//GEN-LAST:event_menuutamaActionPerformed

    private void logoutmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutmenuActionPerformed
        // TODO add your handling code here:
        confirm = JOptionPane.showConfirmDialog(this, "anda yakin untuk logout ?", "konfirmasi !", JOptionPane.YES_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
            
            login Lg = new login();
            Lg.setVisible(true);
            Lg.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_logoutmenuActionPerformed

    private void profilmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilmenuActionPerformed
        // TODO add your handling code here:
        dispose();
        
        profil profil = new profil();
        profil.setVisible(true);
        profil.setLocationRelativeTo(null);
    
        
        
    }//GEN-LAST:event_profilmenuActionPerformed

    private void keluarmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarmenuActionPerformed
        // TODO add your handling code here:
        confirm = JOptionPane.showConfirmDialog(this,"yakin untuk keluar dari aplikasi ?", "konfirmasi !", 
                JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION)
            dispose();
        JOptionPane.showConfirmDialog(this, "anda telah keluar dari aplikasi, terima kasih !", "info !", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_keluarmenuActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem keluarmenu;
    private javax.swing.JMenuItem logoutmenu;
    private javax.swing.JMenuItem menuutama;
    private javax.swing.JMenuItem profilmenu;
    // End of variables declaration//GEN-END:variables
}
