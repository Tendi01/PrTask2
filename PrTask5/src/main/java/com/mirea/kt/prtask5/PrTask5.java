/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mirea.kt.prtask5;
import java.io.*; 

/**
 *
 * @author user
 */
public class PrTask5 {
     System.out.println("Practical task №5 Variant 3. Student Bursikova T.A. Group RIBO-04-21");

     private static byte[] hexStringToByteArray(String s) { 
        int len = s.length(); 
        byte[] data = new byte[len / 2]; 
        for (int i = 0; i < len; i += 2) { 
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) 
                                 + Character.digit(s.charAt(i+1), 16)); 
        } 
        return data; 
    } 
    public static void main(String[] args) {
        try { 
            // получаем путь к исходному файлу и гамму от пользователя 
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
            System.out.print("Введите путь к файлу: "); 
            String filePath = reader.readLine(); 
            System.out.print("Введите гамму в шестнадцатеричном формате: "); 
            String gammaHex = reader.readLine(); 
             
            // считываем байты из исходного файла 
            FileInputStream fis = new FileInputStream(filePath); 
            byte[] fileContent = new byte[fis.available()]; 
            fis.read(fileContent); 
            fis.close(); 
             
            // декодируем гамму из шестнадцатеричного формата 
            byte[] gamma = hexStringToByteArray(gammaHex); 
             
            // производим операцию XOR над каждым байтом из файла 
            for (int i = 0; i < fileContent.length; i++) { 
                fileContent[i] ^= gamma[i % gamma.length]; 
            } 
             
            // записываем результат в новый файл 
            File outputFile = new File("output.bin"); 
            FileOutputStream fos = new FileOutputStream(outputFile); 
            fos.write(fileContent); 
            fos.close(); 
             
            System.out.println("Успешно выполнено! Результат сохранен в файл '" + outputFile.getAbsolutePath() + "'."); 
        } catch (IOException e) { 
            System.out.println("Ошибка: " + e.getMessage()); 
        } 
    } 
 
   
}
