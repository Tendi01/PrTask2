package com.mirea.kt.android2023;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;

public class HTTPRunnable implements Runnable{
    private String method;
    //Тело ответа на запрос хранится как закрытая переменная
    private String address;
    private HashMap<String, String> requestBody;
    //HashMap, содержащий любые параметры запроса, которые необходимо включить в тело запроса
    private String responseBody;
    //веб-адрес для отправки запроса
    private static final String TAG = "HTTPRequestRunnable";
    //класс имеет закрытый метод HTTP

    //конструктор, который устанавливает переменные-члены,
    // и методы для доступа к переменным-членам метода и тела ответа
    public HTTPRunnable(String method, String address, HashMap<String, String> requestBody) {
        this.method = method;
        this.address = address;
        this.requestBody = requestBody;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public String getMethod() {
        return method;
    }

    //закрытый метод, который создаёт строковое представление параметров запроса в правильном формате
    //для использования в HTTP-запросе
//которые должны быть включены в тело запроса
    private String generateStringBody() {
        StringBuffer sbParams = new StringBuffer(); //инициализирует StringBuffer с именем sbParams
        if (requestBody != null && !requestBody.isEmpty()) { //проверяет, не является ли requestBody нулевым и не пустым
            // принимает хэш-карту requestBody
            // создает закодированную строку пар ключ-значение в формате, необходимом для тела HTTP-запроса
            int i = 0;
            for (String key : this.requestBody.keySet()) {
                try {
                    if (i != 0) {
                        sbParams.append("&");
                    }
                    //пытается закодировать URL-адрес для каждого значения с помощью URLEncoder.encode()
                    sbParams.append(key).append("=")
                            //метод добавляет каждый ключ и закодированное значение в буфер sbParams в формате ключ=значение, разделенные символом амперсанда &
                            .append(URLEncoder.encode(this.requestBody.get(key), "UTF-8"));
                } catch (Exception e) { //если что, метод регистрирует сообщение об ошибке
                    Log.d(TAG, "generateStringBody: generateStringBody error");
                }
                i++;
            }
        }
        return sbParams.toString();//метод возвращает строковое представление буфера sbParams
    }


    //Метод doPostRequest() отправляет HTTP-запрос POST на указанный адрес URL с параметрами запроса и получает ответ в виде строки.
    private void doPostRequest() {
        if (this.address != null && !this.address.isEmpty()) { //если переменная не пустая и не нулевая, то
            try { //инициализирует новый URL-адрес и объект URLConnection с URL-адресом
                URL url = new URL(this.address);
                URLConnection connection = url.openConnection();
                HttpURLConnection httpConnection = (HttpURLConnection) connection; //приводит этот URLConnection к объекту HttpURLConnection
                httpConnection.setRequestMethod("POST"); //устанавливает метод запроса на «POST»
                httpConnection.setDoOutput(true); //разрешает вывод для этого соединения
//Затем метод открывает OutputStreamWriter для записи закодированных параметров запроса в URL-соединение
                OutputStreamWriter osw = new OutputStreamWriter(httpConnection.getOutputStream());
                osw.write(generateStringBody()); //Это делается путем передачи вывода метода generateStringBody() в метод osw.write()
                osw.flush();//Метод osw.flush() вызывается, чтобы убедиться, что все данные отправлены на сервер.

                int responseCode = httpConnection.getResponseCode();
                if (responseCode == 200) {
//если получени код ответа 200(ок), метод инициализирукт новый InputStreamReader и BufferedReader
// для чтения ответа с сервера и добавляет строку ответа в StringBuilder
                    InputStreamReader isr = new InputStreamReader(httpConnection.getInputStream());
                    BufferedReader br = new BufferedReader(isr);
                    String currentLine;
                    StringBuilder sbResponse = new StringBuilder();
                    while ((currentLine = br.readLine()) != null) {
                        sbResponse.append(currentLine);
                    } ////Эта дабавленная строка устанавливается как responseBody объекта.
                    responseBody = sbResponse.toString();
                }

            } catch (Exception e) { //метод регистрирует сообщение об ошибке
                Log.d(TAG, "doPostRequest: doPostRequest error");
            }
        }
    }

    //Java-код выполняет HTTP GET-запрос к серверу , используя обработчик URL-адресов
    // для установления соединения с сервером и получения в ответ контента (responseBody).
    private void doGetRequest() {
        if (this.address != null && !this.address.isEmpty()) {
            try {
                //Адрес, который будет использован в запросе, формируется путём
                // конкатенации значений адреса и параметров, созданных методом generateStringBody()
                URL url = new URL(this.address + "&" + generateStringBody());
                URLConnection connection = url.openConnection();
                HttpURLConnection httpConnection = (HttpURLConnection) connection;
                httpConnection.setRequestMethod("GET");

                int responseCode = httpConnection.getResponseCode();
                if (responseCode == 200) { //код состояния 200
//Если ответный код HTTP равен 200,
// то контент передается в StringBuilder и преобразовывается в строку - responseBody
                    InputStreamReader isr = new InputStreamReader(httpConnection.getInputStream());
                    BufferedReader br = new BufferedReader(isr);
                    String currentLine;
                    StringBuilder sbResponse = new StringBuilder();
                    while ((currentLine = br.readLine()) != null) {
                        sbResponse.append(currentLine);
                    }
                    responseBody = sbResponse.toString(); //получения в ответ контента (responseBody)
                }


            } catch (Exception e) { //сообщение об ошибке
                Log.d(TAG, "doGetRequest: doGetRequest error");
            } //исходное значение контента (responseBody) сохраняется как null
        }
    }
    //УБРАТЬ ГЕТ ИЛИ ПОСТ ЗАПРОС НЕ ПОМНЮ ЧТО ИМЕННО
    //проверяется значение переменной method и в зависимости от того, равно ли оно строке
    // "POST" или "GET", вызывает соответствующие методы doPostRequest() или doGetRequest()
    @Override
    public void run() {
        if (method == "POST") {
            doPostRequest();
        } else if (method == "GET") {
            doGetRequest();
        }
    }
}
