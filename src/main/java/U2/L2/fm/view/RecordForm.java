package U2.L2.fm.view;

import U2.L2.fm.model.comboBoxModel.ComboboxCategoryModel;
import U2.L2.fm.model.datasets.Category;
import U2.L2.fm.model.interfaces.GUI;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Сергеева on 04.04.2016.
 */
public class RecordForm extends JFrame{
    private GUI controller;
    private Boolean succeed;





    public RecordForm(GUI controller) {
        this.controller = controller;

        setTitle("Новая транзакция");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        //setModal(true);
        setResizable(false);

        Box main = Box.createVerticalBox();
        Box descPane = Box.createHorizontalBox();
        JLabel lDescription = new JLabel("Описание: ");
        JTextField tDescription = new JTextField(26);

        descPane.add(lDescription);
        descPane.add(tDescription);

        Box categoryPane = Box.createHorizontalBox();
        JLabel lCategory = new JLabel("Категория: ");
        String[] categoryNames = getCategoriesForComboCategories(this.controller);
        JComboBox<String> comboBoxCategory = new JComboBox<>(categoryNames);

        categoryPane.add(lCategory);
        categoryPane.add(comboBoxCategory);

        Box amountPane = Box.createHorizontalBox();
        JLabel lAmount = new JLabel("Сумма");
        JTextField tAmount = new JTextField(15);

        JLabel lExpend = new JLabel("Расход");
        JCheckBox chExpend = new JCheckBox();

        amountPane.add(lAmount);
        amountPane.add(tAmount);
        amountPane.add(Box.createHorizontalGlue());
        amountPane.add(lExpend);
        amountPane.add(chExpend);

        Box datePane = Box.createHorizontalBox();
        JLabel lDate = new JLabel("Дата: ");
        JTextField tDate = new JTextField(26);

        datePane.add(lDate);
        datePane.add(tDate);

        Box ctrPane = Box.createHorizontalBox();
        JButton btnOk = new JButton("OK");
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> dispose());
        JButton btnAddCategory = new JButton("Добавить категорию");
        btnAddCategory.addActionListener( e-> new CategoryForm(controller, this).start());


        ctrPane.add(btnOk);
        ctrPane.add(btnCancel);
        ctrPane.add(Box.createHorizontalGlue());
        ctrPane.add(btnAddCategory);

// TODO: 05.04.2016 добавить позицию дата в форму и JLabel (кликабельный) для добавления категории

        main.add(descPane);
        main.add(categoryPane);
        main.add(amountPane);
        main.add(ctrPane);


        getContentPane().add(main);


        pack();



    }

    @NotNull
    private String[] getCategoriesForComboCategories(GUI controller) {
        ComboboxCategoryModel<Category> cm = new ComboboxCategoryModel<>();
        cm.setCategories(controller.getCategories());
        String[] categoryNames = new String[cm.getSize()];
        for (int i = 0; i < categoryNames.length; i++) {
           categoryNames[i] = cm.getElementAt(i).getNameCategory();
        }
        return categoryNames;
    }

    // TODO: 05.04.2016 updateCategories()

    public void start(){
        setVisible(true);
    }
}
