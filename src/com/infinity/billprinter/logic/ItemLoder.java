/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.billprinter.logic;

import com.infinity.billprinter.gui.ItemListEditer;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Lahiru
 */
public class ItemLoder {

    public ItemLoder() {
        file = new File("./item.txt");
       itemLode();
    }
    private FileInputStream fis;
    private String itemHoler;
    private File file;

    private synchronized String itemLode() {
        try {
            fis = new FileInputStream(file);
            byte[] buf = new byte[fis.available()];
            fis.read(buf);
            itemHoler = new String(buf);
            
        }catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, "ex:101  " + ex, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
           newEmptyFile();
           new ItemListEditer(new Frame(), true).setVisible(true);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ex:101  " + ex, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } finally {
            try {

                fis.close();

            } catch (IOException ex) {
                System.exit(-1);
            }
            return itemHoler;
        }
    }

    public Vector forCombo() {
        Vector v = new Vector();
        String[] split = itemHoler.split("\n");
        for (String string1 : split) {
            String[] split1 = string1.split("#");
            v.addElement(split1[0]);
        }
        return v;
    }

    public Vector<Float> forVal() {
        Vector<Float> v = new Vector<Float>();
        String[] split = itemHoler.split("\n");
        for (String string1 : split) {
            String[] split1 = string1.split("#");
            v.addElement(Float.parseFloat(split1[1]));
        }
        return v;
    }
    public String geString(){
        return itemLode();
    }
    private void newEmptyFile(){
        try {
            FileOutputStream fos =new FileOutputStream(file);
            String s ="itemName#value\n" +
                    "item1#00.00\n";
            byte[] bytes = s.getBytes();
            fos.write(bytes);
        } catch (IOException ex) {
            
        }
    }
}
