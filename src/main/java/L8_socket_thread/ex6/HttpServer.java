package L8_socket_thread.ex6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Сергеева on 15.03.2016.
 *
 * многопоточная версия
 * мы сделаем отдельный класс, который будет заниматься обработкой нашего потока
 */
public class HttpServer {

    public static void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8082);

        while (true) {
            Socket socket = serverSocket.accept();

            new Thread(new SocketDispatcher(socket)).start();
        }


        //serverSocket.close();
    }


}
