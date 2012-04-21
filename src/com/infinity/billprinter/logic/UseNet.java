/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.billprinter.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Lahiru
 */
public class UseNet {

    File file;

    public UseNet() {
        file = new File("./netconfig");
    }

    public void writeHD(Boolean b) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeBoolean(b);
        } catch (Exception e) {
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException ex) {
            }
        }

    }

    public Boolean getFormHD() {
        Boolean b = false;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            b = ois.readBoolean();
        } catch (Exception e) {
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException ex) {
            }

            return b;
        }

 
    }
    public static void main(String[] args) {
       
    }
}
