package U2.L2.fm.view;

import U2.L2.fm.model.comboBoxModel.CategoryModel;
import U2.L2.fm.model.interfaces.GUI;

import javax.swing.*;

/**
 * Created by Сергеева on 05.04.2016.
 */
public class CategoryForm extends JDialog {
    private static final long serialVersionUID = 517367056193730429L;
    private GUI controller;
    private RecordForm parent;
    private Boolean succeeded;

    public CategoryForm(GUI controller, RecordForm parent) {
        this.controller = controller;
        this.parent = parent;
        createGUIForm();
    }


    private void createGUIForm(){

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setTitle("Добавить категорию");

        setLocationRelativeTo(null);
        setResizable(false);

        Box main = Box.createVerticalBox();
        Box descPane = Box.createHorizontalBox();
        JLabel lDescription = new JLabel("Название: ");
        JTextField tDescription = new JTextField(26);

        descPane.add(lDescription);
        descPane.add(tDescription);

        Box ctrPane = Box.createHorizontalBox();
        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(e -> {
            if (controller.addCategory(tDescription.getText())){
                JOptionPane.showMessageDialog(CategoryForm.this, "Новая категория " + tDescription.getText() +
                        " is added.", "Новая категория", JOptionPane.INFORMATION_MESSAGE);
                succeeded = true;
                //после закрытия формы обновить данные на RecordForm
                CategoryModel model = new CategoryModel();
                model.setCategories(controller.getCategories());

                parent.updateComboBox(model);
                dispose();
            }
        });
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> dispose());
        ctrPane.add(btnOk);
        ctrPane.add(btnCancel);

        main.add(descPane);
        main.add(ctrPane);

        getContentPane().add(main);

    }

    public void start(){
        pack();
        setVisible(true);
    }

}
