package ex1;

/**
 * Created by Сергеева on 09.03.2016.
 */
public class Main {
    class NoName2 implements Flyable{

        @Override
        public void fly() {

        }

    }
    /**
     * Статический вложенный класс. Его проще создавать и к нему проще обращаться (Main.NoName3 noname3 = new Main.NoName3();)
     */

    static class NoName3 implements Flyable{

        @Override
        public void fly() {

        }


    }

    public static void main(String[] args) {

        Main.NoName3 noName3 = new Main.NoName3();
        /*
        Чтобы создать объект класса вложенного нестатического нужно сначала создать экземляр класса Main (главного класса)
        и только после этого можно создать экземпляр вложенного класса
         */
        Main main = new Main();
        NoName2 noName2 = main.new NoName2();


        /*
        вложенный в метод класс
         */
        class NoName implements Flyable{

            @Override
            public void fly() {

            }


        }

        //анонимный внутренний класс
       Flyable object = new Flyable(){

           @Override
           public void fly() {
               System.out.println("I'm flying");
           }
       };

        object.fly();



        setFlyable(new Flyable() {
            @Override
            public void fly() {
                System.out.println("Quick and out");
            }


        });

        setFlyable(()->System.out.println("From lambda"));

    }

    public static void setFlyable(Flyable f){
        f.fly();
    }
}
