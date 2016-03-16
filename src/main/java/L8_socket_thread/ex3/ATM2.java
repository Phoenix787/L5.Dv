package L8_socket_thread.ex3;

/**
 * Created by Сергеева on 15.03.2016.
 */
public class ATM2 {
    static int money = 100;
    final Object waitObject = new Object(); //ключом может быть любой объект, в нем хранится информация, взят этот объект или не взят




    //один поток зашел и никакой другой поток зайти туда не может
    //синхронизируем только кусок кода
    public void getMoney(int amount){
       synchronized (waitObject) {
           if (amount <= money) {
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               money -= amount;
               System.out.println("All ok! New amount: " + money);
           } else {
               System.out.println("Not enough money!");
           }
       }

        System.out.println("well done");
    }
}
