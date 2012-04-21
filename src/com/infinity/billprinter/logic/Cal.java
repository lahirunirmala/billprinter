/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.billprinter.logic;

import java.text.NumberFormat;
import java.util.Vector;

/**
 *
 * @author Lahiru
 */
public class Cal {

    public static Object[] tableLine(String name, Vector<Float> v, int amount, int id) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        try {
            Float aPrice = v.get(id);

            final int finamount = amount;
            if (amount < 50) {
                amount *= 1000;
                float totalp = aPrice * (amount / 1000);
                Object[] row = {name, finamount, nf.format(totalp)};
                return row;
            }
            float totalp = (aPrice / 1000) * amount;
            Object[] row = {name, finamount, nf.format(totalp)};
            return row;
        } catch (ArrayIndexOutOfBoundsException ex) {
            Object[] row = {name, 00, nf.format(amount)};
            return row;
        }
    }

    public static Object[] tableLineSh(String name, Vector<Float> v, int amount, int id) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        try {
            Float aPrice = v.get(id);

            final int finamount = amount;
            float totalp = (aPrice / 1000) * amount;
            Object[] row = {name, finamount, nf.format(totalp)};
            return row;
        } catch (ArrayIndexOutOfBoundsException ex) {
            Object[] row = {name, 00, nf.format(amount)};
            return row;
        }
    }

    public static Object[] tableLineCt(String name, Vector<Float> v, int amount, int id) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String[] split = name.split(";");
        if (!(split.length == 2)) {

        }
        int vv = Integer.parseInt(split[1]);
        float totalp = Float.parseFloat(split[2]);
        totalp = totalp * vv;
        Object[] row = {split[0], vv, nf.format(totalp)};
        return row;
    }
}
