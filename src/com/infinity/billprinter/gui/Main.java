/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.billprinter.gui;

import com.stefankrause.xplookandfeel.XPLookAndFeel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author Lahiru
 */
public class Main {

    public static void main(String[] args) {
        try {
           // LookAndFeel theme1 = new XPLookAndFeel();
           // UIManager.setLookAndFeel(theme1);
            new MainWindow().setVisible(true);
        } catch (Exception ex) {
            System.exit(0);
        }
    }
}
