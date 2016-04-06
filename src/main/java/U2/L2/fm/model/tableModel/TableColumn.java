package U2.L2.fm.model.tableModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Сергеева on 05.04.2016.
 */
public enum TableColumn {

    DESC(0, "Описание"),
    DATE(1,"Дата"),
    AMOUNT(2, "Сумма"),
    CATEGORY(3, "Категория"),
    EXPAND(4, "Расход?");

    private TableColumn(int index, String name){
        this.index = index;
        this.name = name;
    }

    private int index;
    private String name;

    private static Map<Integer, TableColumn> COLUMN_INDEX_NAME_MAP = new HashMap();
    private static List<String> NAMES = new ArrayList<>();

    static{
        for (TableColumn c : TableColumn.values() ) {
            COLUMN_INDEX_NAME_MAP.put(c.index, c);
            NAMES.add(c.name);
        }
    }

    public static TableColumn fromIndex(int colIndex) {
        TableColumn tableColumn = COLUMN_INDEX_NAME_MAP.get(colIndex);
        return (tableColumn != null) ? tableColumn : null;
    }

    public static String[] getNames() {
        return NAMES.toArray(new String[NAMES.size()]);

    }
}
