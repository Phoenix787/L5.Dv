package U2.L1.L1.ex6;

/**
 * Created by Сергеева on 16.03.2016.
 */
public class Main {
    int i;

    public static void main(String[] args) {
        show(new Animal(), 12);
    }

    //мы хотим чтобы метод принимал не только обжект и инт, но и любые типы
    //указываем параметры типов <T, V> перед возвращаемым значением метода

    private static <T, V> void  show(T o, V i) {

        System.out.println(o.toString() + " " + i.toString());

    }


}
