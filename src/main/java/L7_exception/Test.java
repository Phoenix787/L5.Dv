package L7_exception;

/**
 * Created by Сергеева on 14.03.2016.
 *
 */
public class Test {
    public void foo1(){
        foo2();

    }
    public void foo2(){
        try {
            test3();
        } catch (CatException e) {
            System.err.println("Error in test3()");
        }
        System.out.println("doing something");
    }
//
//    public int test1() {
//        return -1;
//    }
//
//    boolean test2() {
//        return false;
//    }

    Cat test3() throws CatException {
        throw new CatException();
    }
}
