/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mirea.kt.pr7;

/**
 *
 * @author user
 */
public class MinThread extends Thread {
    private final int[] seq;
    private int minValue;

    public MinThread(int[] seq) {
        this.seq = seq;
    }

    public int getMinValue() {
        return minValue;
    }

    @Override
    public void run() {
        minValue = seq[0];
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] < minValue) {
                minValue = seq[i];
            }
        }
    }
}