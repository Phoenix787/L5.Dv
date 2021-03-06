package U2.L2.fm.model.util;

import U2.L2.fm.model.datasets.Record;
import java.util.Comparator;


/**
 * Created by Сергеева on 18.03.2016.
 *
 */
public class DateComparator implements Comparator<Record> {
    @Override
    public int compare(Record o1, Record o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
