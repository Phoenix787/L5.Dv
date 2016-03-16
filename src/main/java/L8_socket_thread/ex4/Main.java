package L8_socket_thread.ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Сергеева on 15.03.2016.
 *
 * ctrl+alt+v - выделить переменную
 * напишем простой сервер
 */
public class Main {


    public static void main(String[] args) throws IOException {
        String site = "http://genom38.ru";

        URL url = new URL(site);
        //нужен класс соеднинения по этому url (connection)
       // URLConnection urlConnection = url.openConnection(); // откроется соединение с этим сайтом, появится доступ к нему
// но нам удобнее было бы получить экземляр HttpUrlConnection, так как там есть
        // метод getResponseCode() - получаем ответ


        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        int responseCode = urlConnection.getResponseCode();

        System.out.println(responseCode);

        //прочитать содержимое страницы
        //исходный код страницы, то что приходит по http
        // нужно открыть поток для чтения
        // он работает побайтово и медленно
      //  InputStream inputStream = urlConnection.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
        String input;
        StringBuilder result = new StringBuilder();
        while ((input = reader.readLine()) != null) {
            result.append(input).append("\n");

        }

        System.out.println(result.toString());

    }
}
