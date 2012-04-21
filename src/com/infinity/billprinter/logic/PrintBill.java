/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.billprinter.logic;

import com.infinity.billclint.gui.BillDataSender;
import com.infinity.billclint.gui.PopUpWindow;
import com.infinity.billprinter.gui.MiniProgress;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author Lahiru
 */
public class PrintBill {

    
    
    private FileOutputStream fos;
    private String itemData = "|\t\t\t\t|\n";

    public void printBill(String[] data, Vector v, MiniProgress f) {
        String x = new CompnyLoder().getStrig();
        String[] split = x.split(";");
        String comp = split[0];
        String lastwish = split[1];
        //String comand = split[2];
        Vector v1 = v;
        Enumeration a1 = v1.elements();
        File file = new File("D:/bills\\bill" + data[0] + ".txt");
        while (a1.hasMoreElements()) {


            Vector info2 = (Vector) a1.nextElement();
            Object[] info1 = info2.toArray();
            String a = String.valueOf(info1[0]);
            String b = String.valueOf(info1[1]);
            String c = String.valueOf(info1[2]);
            if (a.length()<5) {
                itemData = itemData + "| " + a + "\t\t" + b + "\t" + c + "\t|\n";
            } else {
                 itemData = itemData + "| " + a + "\t" + b + "\t" + c + "\t|\n";
            }
            

        }

        try {

            fos = new FileOutputStream(file);
            String print = "\t" + comp + "\n" +
                    "--------------------------------\n" +
                    "Bill" + "\t\t" + data[1] + "\n" +
                    "\t\t" + data[2] +
                    "\n--------------------------------\n" +
                    "+-------------------------------+\n" +
                    "| Item\t\tAmount\tPrice\t|" +
                    "\n+-------------------------------+\n" +
                    itemData +
                    "+-------------------------------+\n\n" +
                    "\tTotel\t\t" + data[3] +
                    "\n\tPayment\t\t" + data[4] +
                    "\n\t\t\t========" +
                    "\n\tBalance\t\t" + data[5] +
                    "\n\t\t\t--------" +
                    "\n:::::::::::::::::::::::::::::::::\n" +
                    "\n\t" + lastwish +
                    "\n" +
                    "\t(c)Lahiru";

            final String dstr ="["+data[1]+data[2]+"]>"+PopUpWindow.PC_ID+" is Printing bill "+data[0]+" ... Totel " + data[3]+" Payment "+data[4]+" **Balance** "+data[5]+"~";
            new BillDataSender(PopUpWindow.MASTER_IP, dstr);
            fos.write(print.getBytes());

            // Runtime.getRuntime().exec(comand+file.getPath());
            // new File :?             
            // need good code here !! Hard coded here 
            File pf = new File("D:/bills\\bill" + data[0] + ".txt");
            if (pf.exists()) {
                pf.setReadable(true);

                Desktop.getDesktop().print(pf);
            }

        } catch (IOException ex) {
        } finally {
            try {
                fos.flush();
                fos.close();
            // System.out.println("Done !!");



            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    }
}
