/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infinity.billclint.gui;

import java.io.IOException;

/**
 *
 * @author Lahiru
 */
public class SystemProssesHandaler {
    public static final String SHOUTDOWN ="s";
    public static final String RESTART ="r";
    public static void systemHook(String args) {
       new SystemProssesHandaler().prosses(args);
    }
  
    private void prosses(String args){
     try {
            Runtime.getRuntime().exec("Shutdown -"+args+" -t 60");
        } catch (IOException ex) {
           
        }
    }
    
    public static void main(String[] args) {
        systemHook(SystemProssesHandaler.SHOUTDOWN);
    }
}
