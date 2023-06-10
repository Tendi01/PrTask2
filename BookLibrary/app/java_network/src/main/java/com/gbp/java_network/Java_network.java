/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.gbp.java_network;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author gbp_a
 */
public class Java_network {

    public static void main(String[] args) {
        String server = "https://android-for-students.ru";
        String path   = "/coursework/login.php";
        String path2 = "/materials/practical/hello.php";
        
        String lgn="Student96295";
        String pwd="StYZpPr"; //заменить
        String g ="RIBO-04-21";
        
        HashMap<String,String> map = new HashMap();
        map.put("lgn",lgn);
        map.put("pwd",pwd);
        map.put("g",g);
        map.put("name", "Shuvalov");
        map.put("group", "RIBO-04-21");
        HTTPRunnable httpRunnable = new HTTPRunnable(server+path, map);
        Thread th = new Thread(httpRunnable);
        th.start();
        try{
            th.join();
        } catch (InterruptedException ex){
            //
        } finally {
            JSONObject jSONObject = new JSONObject(httpRunnable.getResponseBody());

            int result = jSONObject.getInt("result_code");
            System.out.println("Result code:"+result);
            System.out.println(jSONObject.toString());
            switch(result){
                case 1:
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        }
    }
}
