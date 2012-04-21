/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.billprinter.res;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author Lahiru
 */
class NewClass {

    private NewClass(){}
    
    public static void main(String[] args) {
    }
    private static FileOutputStream fos;

    public static void printBill(String[] data, Vector v) {
        String comp = "ABC";
        String itemData = null;
        Enumeration a1 = v.elements();
        while (a1.hasMoreElements()) {


            Vector info2 = (Vector) a1.nextElement();
            Object[] info1 = info2.toArray();
            String a = String.valueOf(info1[0]);
            String b = String.valueOf(info1[1]);
            String c = String.valueOf(info1[2]);
            itemData = itemData + "|\t" + a + "\t" + b + "\t" + c + "\t|\n";

        }

        try {
            File f = new File("C:/bill.txt");
            fos = new FileOutputStream(f);

            String print = "\t" + comp + "\n" +
                    "--------------------------------\n" +
                    data[0] + "\t" + data[1] + "\n" +
                    "\t\t\t" + data[2] + "--------------------------------\n" +
                    "================================\n" +
                    "\tItem\tAmount\tPrice" +
                    "+-------------------------------+\n" + itemData +
                    "+-------------------------------+\n" +
                    "\t\tTotel\t" + data[3] +
                    "\t\tPayment\t" +
                    "\t\t\t========" +
                    "\t\tBalance\t" +
                    "\t\t\t--------" +
                    "\tThank you come agan !!" +
                    "\n" +
                    "\t(c)Lahiru";
            fos.write(print.getBytes());
        } catch (IOException ex) {
        } finally {
            try {
                fos.flush();
                fos.close();
            } catch (IOException ex) {
            }
        }


    }
}
