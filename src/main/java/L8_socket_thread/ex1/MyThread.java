package L8_socket_thread.ex1;

/**
 * Created by Сергеева on 15.03.2016.
 */
public class MyThread extends Thread {
    public int s;

    public MyThread(int s) {
        this.s = s;
    }

    @Override
    public void run() {
        System.out.println("MyThread - " + s);
    }
}
