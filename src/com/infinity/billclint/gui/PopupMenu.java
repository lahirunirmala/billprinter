/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infinity.billclint.gui;

//import com.stefankrause.xplookandfeel.XPLookAndFeel;
import java.awt.AWTException;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author Lahiru
 */
public class PopupMenu {
    private java.awt.MenuItem munRestor;
    private java.awt.MenuItem munExit;
    private  java.awt.PopupMenu pop;
    private JFrame popUpWindow;
    

    public PopupMenu() {
        try {
            intiComp();
            popUpWindow = new PopUpWindow();
            new PortLisner();
        } catch (IOException ex) {
            
        }
    }
            
    private void intiComp(){
        munRestor =new java.awt.MenuItem("Restor");
        munRestor.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
              popUpWindow.setVisible(true);
            }
        });
        munExit =new java.awt.MenuItem("Exit");
        munExit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                System.exit(0);
            }
        });
        munRestor.setFont(new Font("Tahoma", Font.BOLD, 12));
        munExit.setFont(new Font("Tahoma", Font.PLAIN, 11));
        pop=new java.awt.PopupMenu();
        pop.add(munRestor);
        pop.addSeparator();
        pop.add(munExit);
        
        }
    
    public void showIcon(){
        try {
            SystemTray sT = SystemTray.getSystemTray();
            Image i = java.awt.Toolkit.getDefaultToolkit().createImage("./sysicon.png");
            TrayIcon ti = new TrayIcon(i, "BillPinter", pop);
            sT.add(ti);
        } catch (AWTException ex) {
            
        }
    }
    
    public static void main(String[] args) {
        try {
            //LookAndFeel theme1 = new XPLookAndFeel();
            //UIManager.setLookAndFeel(theme1);
            
        } catch (Exception ex) {
            System.exit(0);
        }
        
        new PopupMenu().showIcon();
    }
}
