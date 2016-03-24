package U2.L3.windowlistener;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Ксения on 24.03.2016.
 */
public class DatabaseListModel<T> extends AbstractListModel<T> {
    //здесь будем хранить данные из бд
    private final ArrayList<T> data = new ArrayList<>();

    //загрузка из базы данных
    public void setDataSource(Set<T> rs) {
        try {
            data.clear();
            while (rs.iterator().hasNext()) {
                synchronized (data) {
                    data.add(rs.iterator().next());
                }
                //оповещаем виды если они есть
                fireIntervalAdded(this, 0, data.size());
            }

            fireContentsChanged(this, 0, data.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        //методы модели для выдачи данных списку
    @Override
    public int getSize() {
        synchronized (data) {
            return data.size();
        }

    }

    @Override
    public T getElementAt(int index) {

        synchronized (data) {
            return data.get(index);
        }

    }
}
