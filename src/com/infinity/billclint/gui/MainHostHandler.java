/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.billclint.gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Lahiru
 */
public class MainHostHandler {

    private  File file = new File("./mainhost");
    private String data;
    public String getFromHD() {

        
        FileInputStream fin = null;
        DataInputStream dis = null;
       


        try {

            fin = new FileInputStream(file);
            dis = new DataInputStream(fin);
             data = dis.readUTF();
            
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "File Not Found", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
        } finally {
            try {
                dis.close();
                fin.close();

            } catch (IOException ex) {
            }
        }
        return data;

    }

    public void writeToHD(String a) {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream(file);
            dos = new DataOutputStream(fos);
            dos.writeUTF(a);
        } catch (Exception e) {
        } finally {
            try {
                dos.flush();
                fos.flush();
                dos.close();
                fos.close();
            } catch (IOException ex) {
            }
        }
    }
}
    
