package L8_socket_thread.ex3;

/**
 * Created by Сергеева on 15.03.2016.
 * плохая ситуация
 */
public class Main {
    public static void main(String[] args) {

        ATM atm = new ATM();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("Mikki: " );
                atm.getMoney(50);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("Loe: ");
                atm.getMoney(50);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("Bobby: ");
                atm.getMoney(50);

            }
        }).start();

    }
}
