package U2.L1.L1.ex8;

/**
 * Created by Ксения on 16.03.2016.
 */
public class Gen2<T extends Number> {
    T number;

    void foo(){
//        Gen2<Integer>[] integers;
//        integers = new Gen2<Integer>[3];
//

        Gen2<?>[] integers;
        integers = new Gen2<?>[3];
    }
}
