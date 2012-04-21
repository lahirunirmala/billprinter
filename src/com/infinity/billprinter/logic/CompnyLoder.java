/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.billprinter.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Lahiru
 */
public class CompnyLoder {

    private FileInputStream fis;
    private String itemHoler;
    private File file;

    public String getStrig() {
        try {
            file = new File("./config.cgf");
            fis = new FileInputStream(file);
            byte[] buf = new byte[fis.available()];
            fis.read(buf);
            itemHoler = new String(buf);
            return itemHoler;
        } catch (IOException ex) {
            itemHoler="";
            return itemHoler;
        } finally {
            try {

                fis.close();

            } catch (IOException ex) {
            }
        }
    }
}
