package L8_socket_thread.ex1;

/**
 * Created by Сергеева on 15.03.2016.
 *
 */
public class Main {

    //первый вариант через интерфейс (тогда передаем в конструктор классу Thread
    static class Recipe implements Runnable{
        void cook(){
            System.out.println(Thread.currentThread().getName() );
        }

        @Override
        public void run() {
            for (int i = 0; i < 20 ; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }

    public static void main(String[] args) {


        //Второй вариант расширяем класс Thread,
        // если гарантированно знаем что не будет предков

        Thread threadR = new Thread(new Recipe());
        threadR.start();

        for (int i = 0; i < 10; i++) {
           new MyThread(i).start();

        }
        System.out.println(Thread.currentThread().getName());

        new Thread(() -> {
            System.out.println("Анонимный ПОВАР");
        }).start();


    }

    //часто будет одна чашка на несколько потоков (один разделяемый ресурс)
    //нужно как-то между потоками обмениваться данными
    //нужно запрещать из одной чашки есть нескольким потокам


}
