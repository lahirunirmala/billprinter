/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infinity.billclint.gui;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Lahiru
 */
public class BillDataSender implements Runnable{
final private String host, dstr;;
    public void run() {
       sendMessage(host, dstr);
    }

    public BillDataSender(String host, String dstr) {
        this.host = host;
        this.dstr = dstr;
        new Thread(this).start();
    }
private void sendMessage(String host,String dstr){
        try {
            Socket s = new Socket(host, 8889);
            s.getOutputStream().write(dstr.getBytes());
        } catch (UnknownHostException ex) {
          
        } catch (IOException ex) {
           
        }
    }
}
