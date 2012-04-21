/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infinity.billprinter.logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Lahiru
 */
public class CompnyWriter {
private FileOutputStream fos;
    private String itemHoler;
    private File file;
    
    public void writeData(String head,String foot){
        try {
            file =new File("./config.cgf");
            fos =new FileOutputStream(file);
            itemHoler =head+";"+foot+";";
            fos.write(itemHoler.getBytes());
        } catch (Exception e) {
        }finally{
            try {
                fos.flush();
                fos.close();
            } catch (IOException ex) {
               
            }
        }
    }
}
