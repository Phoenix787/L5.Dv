package U2.L1.L1.l1_dz2;

import java.util.*;

/**
 * Created by Сергеева on 17.03.2016.
 *
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("bbb", "aa", "eeee");

        Collections.sort(list, new LengthComparator());
        System.out.println(list);
    }
}
