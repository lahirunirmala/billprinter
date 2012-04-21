/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infinity.billprinter.logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lahiru
 */
public class ItemWriter {
    private FileOutputStream fos;
    private String holde="";
    private File f;
    
    
    
    public void doStuff(Vector v){
        try {
            f = new File("./item.txt");
            fos = new FileOutputStream(f);
            
             Vector v1 =v;
        Enumeration a1 = v1.elements();
        while (a1.hasMoreElements()) {


            Vector info2 = (Vector) a1.nextElement();
            Object[] info1 = info2.toArray();
            String a = String.valueOf(info1[0]);
            String b = String.valueOf(info1[1]);
           holde=holde+a+"#"+b+"\n";
        }
            fos.write(holde.getBytes());
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, "ex:101" + ex, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
           
        }finally{
            try {
                fos.flush();
                fos.close();
            } catch (IOException ex) {
              
            }
        }
    
    
    
    }
    
}
