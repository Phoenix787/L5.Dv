package L8_socket_thread.ex5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Сергеева on 15.03.2016.
 * Все компьютеры идентифицируются по ip-адресу. Но этого недостаточно (ip-адрес - это как номер дома)
 * Внутри компьютера нам нужно обратиться к какой-то программе (это как номер квартиры)
 * Отличаются с помощь портов (номер ячейки у которой один хозяин).
 *
 * Сокет = ip-адрес + порт
 *
 * в этом варианте когда заходит один клиент на наш сервер - никто не может больше подключиться
 */
public class HttpServer {
    private int port;

    public static void start() throws IOException {

        ServerSocket serverSocket = new ServerSocket(8082);

        //ожидаем пока кто-нибудь к ней не приконнектится

        //Socket - хранятся потоки ввода/вывода
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        //прочитать

        //вывод на браузер
        String html = "<html>" +
                "<head><title>Super Server</title></head>" +
                "<body><p>Hello, Java!</p><br/>" +
                "<img src='http://nornat.ru/int.php?iaqcn=dxifuci/9416.jpg'></body>" +
                "</html>";

        String header = "HTTP/1.1 200 OK"+
                "Content-Type: text/html\n"+
                "Content-Length: " + html.length() + "\n" +
                "Connection: close \n\n";
        String result = header+html;
        outputStream.write(result.getBytes());

//        OutputStreamWriter out = new OutputStreamWriter(outputStream);
//        out.write(result);

        serverSocket.close();

    }

}
