/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mirea.kt.pr7;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Pr7 {

    public static void main(String[] args) {
        System.out.println("Practical task №7. Variant 3. Student Bursikova T.A. Group RIBO-04-21\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числовую последовательность через запятую:");
        String input = scanner.nextLine();
        String[] numbers = input.split(","); 
//split -  возвращает массив строк, вычисленных путём разделения данной строки вокруг данного регулярного выражения
        int[] seq = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            seq[i] = Integer.parseInt(numbers[i]);
//parseInt - преобразует строку в число 
        }
        MinThread minThread = new MinThread(seq);
        MaxThread maxThread = new MaxThread(seq);
        minThread.start();
        maxThread.start();
        try {
//join - позволяет главному потоку ждать завершение выполнения других зависящих
            minThread.join();
            maxThread.join();
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
        System.out.println("Максимальное значение: " + maxThread.getMaxValue());
        System.out.println("Минимальное значение: " + minThread.getMinValue());
    }
}