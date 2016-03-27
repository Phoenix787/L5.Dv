package U2.L4.ex2;

/**
 * Created by Ксения on 26.03.2016.
 */
public class Test {
    private int i;  //запрещен доступ из других классов, но не из других экземпляров данного класса


    public Test(int i) {
        this.i = i;
    }
//почему удалось получить private переменную из другого класса. Она доступна внутри самого класса, поэтому доступна любым классам внутри данного класса
    public void testing(Test test) {
        System.out.println(i + test.i);
    }

    public static void main(String[] args) {
        Test test1 = new Test(1);
        Test test2 = new Test(2);

        test1.testing(test2);
    }
}
