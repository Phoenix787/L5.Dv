package U2.L2.fm.view;

import U2.L2.fm.model.comboBoxModel.CategoryModel;
import U2.L2.fm.model.comboBoxModel.ComboboxCategoryModel;
import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.datasets.Category;
import U2.L2.fm.model.interfaces.GUI;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Сергеева on 04.04.2016.
 */
public class RecordForm extends JFrame{
    private GUI controller;
    private Boolean succeed;
    private JComboBox<String> comboBoxCategory;
    private final JTextField tDate;
    private final JCheckBox chExpend;
    private final JTextField tAmount;
    private final JTextField tDescription;
    private boolean succeeded;
    private MainWindow parent;


    public RecordForm(GUI controller, Account account, MainWindow parent) {
        this.controller = controller;
        this.parent = parent;

        setTitle("Новая транзакция");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        //setModal(true);
        setResizable(false);

        Box main = Box.createVerticalBox();
        Box descPane = Box.createHorizontalBox();
        JLabel lDescription = new JLabel("Описание: ");
        tDescription = new JTextField(26);

        descPane.add(lDescription);
        descPane.add(tDescription);

        Box categoryPane = Box.createHorizontalBox();
        JLabel lCategory = new JLabel("Категория: ");
      //  String[] categoryNames = getCategoriesForComboCategories(this.controller);
        CategoryModel cm = new CategoryModel();
        cm.setCategories(controller.getCategories());
        comboBoxCategory = new JComboBox<>(cm);

        categoryPane.add(lCategory);
        categoryPane.add(comboBoxCategory);

        Box amountPane = Box.createHorizontalBox();
        JLabel lAmount = new JLabel("Сумма");
        tAmount = new JTextField(15);

        JLabel lExpend = new JLabel("Расход");
        chExpend = new JCheckBox();

        amountPane.add(lAmount);
        amountPane.add(tAmount);
        amountPane.add(Box.createHorizontalGlue());
        amountPane.add(lExpend);
        amountPane.add(chExpend);

        Box datePane = Box.createHorizontalBox();
        JLabel lDate = new JLabel("Дата: ");
        // TODO: 05.04.2016 заменить на что-то типа datePicker
        //JDatePicker datePicker = new JDatePickerImpl();
        tDate = new JTextField(26);


        datePane.add(lDate);
        datePane.add(tDate);

        Box ctrPane = Box.createHorizontalBox();
        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller.addRecord(account, comboBoxCategory.getSelectedItem().toString(), getDate(), getAmount(), isChecked(), getRecDesc())){
                    JOptionPane.showMessageDialog(RecordForm.this, "New account to " + controller.getOwner() +
                            " is added.", "New Account", JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    //после закрытия формы обновить данные на MainWindow JTable datamodel!!!!
//                    Set<String> data = updateListAccount();
//                    DatabaseListModel<String> stringDatabaseListModel = new DatabaseListModel<>();
//                    stringDatabaseListModel.setDataSource(data);
//                    parent.setDim(stringDatabaseListModel);
//                    parent.updateJList();


                    dispose();


                } else{
                    JOptionPane.showMessageDialog(RecordForm.this, "Such account already exists. " +
                            "\nPlease choose another description to account", "New Account", JOptionPane.ERROR_MESSAGE);
                    succeeded = false;
                   // tfDescription.setText("");
                }
            }
        });
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> dispose());
        JButton btnAddCategory = new JButton("Добавить категорию");
        btnAddCategory.addActionListener( e -> new CategoryForm(controller, this).start());


        ctrPane.add(btnOk);
        ctrPane.add(btnCancel);
        ctrPane.add(Box.createHorizontalGlue());
        ctrPane.add(btnAddCategory);

// TODO: 05.04.2016 добавить позицию дата в форму и JLabel (кликабельный) для добавления категории

        main.add(descPane);
        main.add(categoryPane);
        main.add(amountPane);
        main.add(datePane);
        main.add(ctrPane);


        getContentPane().add(main);


        pack();



    }

    @NotNull
    public String[] getCategoriesForComboCategories(GUI controller) {
        ComboboxCategoryModel<Category> cm = new ComboboxCategoryModel<>();
        cm.setCategories(controller.getCategories());
        String[] categoryNames = new String[cm.getSize()];
        for (int i = 0; i < categoryNames.length; i++) {
           categoryNames[i] = cm.getElementAt(i).getNameCategory();
        }
        return categoryNames;
    }

    public void updateComboBox(CategoryModel model) {
        comboBoxCategory.setModel(model);
    }



    // TODO: 05.04.2016 updateCategories()

    public void start(){
        setVisible(true);
    }

    private Date getDate(){
        return new Date(Long.valueOf(tDate.getText()));
    }

    private String getRecDesc(){
        return tDescription.getText();
    }

    private Double getAmount(){
        return Double.valueOf(tAmount.getText());
    }

    private Boolean isChecked() {
        return (chExpend.isSelected())? Boolean.TRUE : Boolean.FALSE;
    }
}
