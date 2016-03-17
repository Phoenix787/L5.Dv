package U2.L1.L1.l1_dz2;

import java.util.Comparator;

/**
 * Created by Сергеева on 17.03.2016.
 *
 */
public class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length()-o2.length();
    }
}
