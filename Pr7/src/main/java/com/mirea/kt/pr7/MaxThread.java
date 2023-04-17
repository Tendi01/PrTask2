/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mirea.kt.pr7;

/**
 *
 * @author user
 */
public class MaxThread extends Thread {
    private final int[] seq;
    private int maxValue;

    public MaxThread(int[] seq) {
        this.seq = seq;
    }

    public int getMaxValue() {
        return maxValue;
    }

    @Override
    public void run() {
        maxValue = seq[0];
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] > maxValue) {
                maxValue = seq[i];
            }
        }
    }
}
