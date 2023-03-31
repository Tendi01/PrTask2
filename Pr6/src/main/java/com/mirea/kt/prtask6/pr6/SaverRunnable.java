/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mirea.kt.prtask6.pr6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author user
 */
public class SaverRunnable implements Runnable {
    private Doctor doctor;
    private String path;

    public SaverRunnable(Doctor doctor, String path) {
        this.doctor = doctor;
        this.path = path;
    }
    
    @Override //перегрузка метода интерфейса Runnable
    public void run(){ 
        if(this.path != null && doctor != null) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.path));
//поток вывода класса запускаем в поток вывода в файл по заданному пути
                oos.writeObject(doctor);//записывание данных объекта Доктор
                oos.close();
                System.out.println("Success serialization obj Doctor");
            } catch (IOException ex) {
                System.out.println("Error saving object to path: " + this.path);
                
            }
        }
    }
}