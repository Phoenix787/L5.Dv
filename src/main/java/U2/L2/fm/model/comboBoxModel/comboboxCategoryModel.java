package U2.L2.fm.model.comboBoxModel;

import U2.L2.fm.model.datasets.Category;
import U2.L2.fm.model.datasets.Record;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Сергеева on 05.04.2016.
 */
public class ComboboxCategoryModel<E> extends DefaultListModel<E> implements ComboBoxModel<E> {

    private final ArrayList<E> categories = new ArrayList<>();
    Object selected;


    public void setCategories(Set<E> rs) {
        Iterator<E> iterator = rs.iterator();
        try {
            categories.clear();
            while (iterator.hasNext()) {
                synchronized (categories) {
                    categories.add(iterator.next());
                }

                //оповещаем views если они есть
                fireIntervalAdded(this, 0, categories.size());

            }
            fireContentsChanged(this, 0, categories.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void setSelectedItem(Object anItem) {

        selected = anItem;
        fireContentsChanged(this, -1, -1);
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }

    public E getElementAt(int index) {
        return categories.get(index);
    }

    public int getSize(){
        return categories.size();
    }
}
