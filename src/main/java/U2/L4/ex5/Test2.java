package U2.L4.ex5;

/**
 * Created by Ксения on 27.03.2016.
 * к каким переменным имеет доступ анонимный внутренний класс
 */
public class Test2 {
    private int i;
    private int p;
    private final static int ifinal = 200;

    public static void main(String[] args) {


        new Test2().testAnonym();

    }

    //когда переменная передается через параметр метода мы тоже не можем с ним работать, не можем ничего присвоить
    //
//    private void testAnonym(int p){


    /*выходи из положения - сделать массив и в первую ячейку сохранить ссылку на параметр метода
    * final int[] ps = new int[1];
    * ps[0] = p;
    * */
    private void testAnonym() {
        int a;
        final int af = 10;

        testAnonym2(p);

        Testable testable = () -> {
            //
            System.out.println(ifinal);
            System.out.println(af);
//                System.out.println(a); //нельзя. к внутренним локальным переменным обратиться нельзя, потому что как только выходим из метода они все очищаются
            System.out.println(i);
            i = 10; //если нужно какие-то данные сохранить, то это получится сделать только в поля класса

        };
        testable.test();
    }


    /*выход из положения - сделать массив и в первую ячейку сохранить ссылку на параметр метода
    * final int[] ps = new int[1];
    * ps[0] = p;
    * не совсем понятно - разобраться!!!!!!!!!!1
    * */
    private void testAnonym2(int p) {
        final int[] pp = new int[1];
        pp[0] = p;
           Testable testable = () -> {
               pp[0] = 12;
               System.out.println(p);
           };
        testable.test();
    }




}
