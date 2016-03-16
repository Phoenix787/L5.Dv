package L8_socket_thread.ex2;

import java.io.IOException;

/**
 * Created by Сергеева on 15.03.2016.
 * два класса: один будет ставить флаг, другой будет его считывать
 * каждый поток внутри себя кеширует переменные, такой способ оптимизации
 * чтобы этого не было - volatile
 */
public class Main {

    public volatile static boolean flag = true;

    static class ThreadFlagReader extends Thread{
        @Override
        public void run() {
            while (flag) {

            }
            System.err.println("ThreadFlagReader completed " + flag);
        }
    }

    static class ThreadFlagSetter extends Thread{
        @Override
        public void run() {

            try {
               int read =  System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

            flag = false;
            System.err.println("Flag set to " + flag);

        }
    }




    public static void main(String[] args) {
        new ThreadFlagReader().start();
        new ThreadFlagSetter().start();
    }
}
