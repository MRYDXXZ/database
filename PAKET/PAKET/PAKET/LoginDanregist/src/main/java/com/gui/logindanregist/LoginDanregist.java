/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.gui.logindanregist;

import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class LoginDanregist {

    public static void main(String[] args) {
     
        login Lg = new login();
        Lg.setVisible(true);
        
        Lg.pack();
        Lg.setLocationRelativeTo(null);
        Lg.setDefaultCloseOperation(login.EXIT_ON_CLOSE);
    }
}
