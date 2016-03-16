package U2.L1.ex4;

/**
 * Created by Сергеева on 16.03.2016.
 *
 */
public class Gen3<T extends Animal & Miauable> {
    T object;

    public Gen3(T object) {
        this.object = object;
    }

    void doubleValue(){
        double d = object.doubleValue();
        System.out.println(d);
    }
}
