package U2.L2.fm.model.comboBoxModel;

import U2.L2.fm.model.datasets.Category;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Сергеева on 05.04.2016.
 */
public class CategoryModel extends DefaultListModel implements ComboBoxModel {

    private final ArrayList<String> categories = new ArrayList<>();
    Object selected;


    public void setCategories(Set<Category> rs) {
        Iterator<Category> iterator = rs.iterator();
        try {
            categories.clear();
            while (iterator.hasNext()) {
                synchronized (categories) {
                    Category category = iterator.next();
                    categories.add(category.getNameCategory());
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

    public String getElementAt(int index) {
        return categories.get(index);
    }

    public int getSize(){
        return categories.size();
    }
}
