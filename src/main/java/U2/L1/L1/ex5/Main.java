package U2.L1.L1.ex5;

/**
 * Created by Сергеева on 16.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        Gen1<Integer> i1 = new Gen1<>(20);
        Gen1<Integer> i2 = new Gen1<>(40);

        i1.showDelta(i2);

        Gen1<Float> f1 = new Gen1<>(40.0f);
        i1.showDelta(f1);


    }
}
