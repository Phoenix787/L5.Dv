package U2.L2.fm.view;

import U2.L2.fm.model.comboBoxModel.CategoryModel;
import U2.L2.fm.model.comboBoxModel.ComboboxCategoryModel;
import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.datasets.Category;
import U2.L2.fm.model.interfaces.GUI;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Сергеева on 04.04.2016.
 *
 */
public class RecordForm extends JDialog{
    private static final long serialVersionUID = -940553145565410582L;
    private GUI controller;
    private JComboBox comboBoxCategory;
    private final JCheckBox chExpend;
    private final JTextField tAmount;
    private final JTextField tDescription;
    private boolean succeeded;
    private Date selectedDate;
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
        
        JDatePickerImpl datePicker = getjDatePicker();        
        setDate((Date) datePicker.getModel().getValue());
        
        datePicker.addActionListener(e -> {
            //выбранную дату в переменную selectedDate
            selectedDate = (Date) datePicker.getModel().getValue();
        });
        
        datePane.add(lDate);
        datePane.add(datePicker);

        Box ctrPane = Box.createHorizontalBox();
        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller.addRecord(account, comboBoxCategory.getSelectedItem().toString(), getDate(), getAmount(), isChecked(), getRecDesc())){
                    JOptionPane.showMessageDialog(RecordForm.this, "New record to " + controller.getOwner() +
                            " is added.", "New Record", JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    // TODO: 06.04.2016 после закрытия формы обновить данные на MainWindow JTable datamodel!!!!

//                    Set<String> data = updateListAccount();
//                    DatabaseListModel<String> stringDatabaseListModel = new DatabaseListModel<>();
//                    stringDatabaseListModel.setDataSource(data);
//                    parent.setDim(stringDatabaseListModel);
//                    parent.updateJList();


                    dispose();


                } else{
                    JOptionPane.showMessageDialog(RecordForm.this, "Ошибка при добавлении транзакции к счету",
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
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

        main.add(descPane);
        main.add(categoryPane);
        main.add(amountPane);
        main.add(datePane);
        main.add(ctrPane);


        getContentPane().add(main);

        pack();
    }

    @NotNull
    private JDatePickerImpl getjDatePicker() {
        UtilDateModel model = new UtilDateModel();
        model.setSelected(true);
        Properties properties = new Properties();
        properties.put("text.today", "Сегодня");
        properties.put("text.today", "Сегодня");
        properties.put("text.today", "Сегодня");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        return new JDatePickerImpl(datePanel, new DateComponentFormatter());
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

    public Date getDate() {
        return selectedDate;
    }

    public void setDate(Date selectedDate) {
        this.selectedDate = selectedDate;
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
