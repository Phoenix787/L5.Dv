package U2.L2.fm.model.tableModel;

import U2.L2.fm.model.datasets.Record;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Сергеева on 05.04.2016.
 */
public class DatabaseTableModel extends AbstractTableModel {

    private static final long serialVersionUID = -2827425648190895598L;

    private final ArrayList<Record> data = new ArrayList<>();
    private String[] columnNames = TableColumn.getNames();
    private Class<?>[] columnClasses = Constants.COLUMN_CLASSES;


    //загрузка из базы данных
    public void setDataSource(Set<Record> rs) {
        Iterator<Record> iterator = rs.iterator();
        try {
            data.clear();
            while (iterator.hasNext()) {
                synchronized (data) {
                    data.add(iterator.next());
                }

                //оповещаем views если они есть
                fireTableRowsInserted(0, data.size());

            }
            fireTableDataChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return Constants.COLUMN_CLASSES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Record record = data.get(rowIndex);
        TableColumn tableColumn = TableColumn.fromIndex(columnIndex);
        switch (tableColumn) {
            case DESC:
                return record.getRecordName();
            case DATE:
                return record.getDate();
            case AMOUNT:
                return record.getAmount();
            case CATEGORY:
                return record.getCategory().getNameCategory();
            case EXPAND:
                return (record.isPut()) ? Boolean.TRUE : Boolean.FALSE;
            default:
                return null;
        }
    }
}
