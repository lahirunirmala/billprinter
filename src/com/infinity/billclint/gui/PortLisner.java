/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.billclint.gui;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Lahiru
 */
public class PortLisner implements Runnable {

    public void run() {
        while (true) {
            String[] split = null;
            try {
                Thread.sleep(100);
                Socket inSocket = serverSocket.accept();
                InputStream inputStream = inSocket.getInputStream();
                byte[] b = new byte[300];
                inputStream.read(b);
                String s = new String(b);
                
                split = s.split("~");
               
               
                int msgType = Integer.parseInt(split[0]);
                String msg = split[1];
               JOptionPane.showMessageDialog(null, msg,serverSocket.getInetAddress().getHostName(), msgType);
                
            }catch (NumberFormatException ex){
                 if (split[0].equalsIgnoreCase("AYT")) {
                    
                   new pullBackMessage(PopUpWindow.MASTER_IP, PopUpWindow.PC_ID); 
                }if(split[0].equalsIgnoreCase("SDW")){
                 
                 SystemProssesHandaler.systemHook(SystemProssesHandaler.SHOUTDOWN);
                }
                if(split[0].equalsIgnoreCase("REST")){
                 
                 SystemProssesHandaler.systemHook(SystemProssesHandaler.RESTART);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

  

    public PortLisner() throws IOException {
        serverSocket = new ServerSocket(8888);
        new Thread(this).start();
    }
    private java.net.ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        new PortLisner();
    }
}
