package L8_socket_thread.ex6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Сергеева on 15.03.2016.
 * обработчик сокетов
 */
public class SocketDispatcher implements Runnable {
    private Socket socket;

    public SocketDispatcher(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            test(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void test(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        String html = "<html>" +
                "<header><title>Super</title>" +
                "<header><body><h1>Hello, " +
                "Java</h1></body></html>";

        String header = "HTTP/1.1 200 OK\n" +
                "Content-Type: text/html\n" +
                "Content-Length: " + html.length() + "\n" +
                "Connection: close\n\n";

        String result = header + html;

        outputStream.write(result.getBytes());
    }
}
