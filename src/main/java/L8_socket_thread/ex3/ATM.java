package L8_socket_thread.ex3;

/**
 * Created by Сергеева on 15.03.2016.
 */
public class ATM {
    static int money = 100;

    //один поток зашел и никакой другой поток зайти туда не может

    // что-то вроде туалета! ))) выстраивается очередь перед ним
    //синхронизированные методы работают медленее
    // закрываем ключевые методы


    public synchronized  void getMoney(int amount){
        if (amount <= money) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            money-=amount;
            System.out.println("All ok! New amount: " + money);
        }
        else {
            System.out.println("Not enough money!");
        }
    }
}
