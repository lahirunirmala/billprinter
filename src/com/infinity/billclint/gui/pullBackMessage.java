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
public class pullBackMessage implements Runnable {
final private String host, pcid;
    public void run() {
        sendMessage(host, pcid);
        
    }

    public pullBackMessage(String host,String pcid) {
        this.host =host;
        this.pcid=pcid;
        
        new Thread(this).start();
    }

    private void sendMessage(String host,String pcid){
        try {
            Socket s = new Socket(host, 8889);
            s.getOutputStream().write(new String(pcid + " is Working .....~").getBytes());
        } catch (UnknownHostException ex) {
          
        } catch (IOException ex) {
           
        }
    }
    
}
