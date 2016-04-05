package U2.L2.fm.view;

import U2.L2.fm.model.interfaces.GUI;

import javax.swing.*;

/**
 * Created by Сергеева on 05.04.2016.
 */
public class CategoryForm extends JDialog {
    private GUI controller;
    RecordForm parent;

    public CategoryForm(GUI controller, RecordForm parent) {
        this.controller = controller;
        this.parent = parent;
        createGUIForm();
    }


    public void createGUIForm(){

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setTitle("Добавить категорию");

        setLocationRelativeTo(null);
        //setModal(true);
        setResizable(false);

        Box main = Box.createVerticalBox();
        Box descPane = Box.createHorizontalBox();
        JLabel lDescription = new JLabel("Название: ");
        JTextField tDescription = new JTextField(26);

        descPane.add(lDescription);
        descPane.add(tDescription);

        Box ctrPane = Box.createHorizontalBox();
        JButton btnOk = new JButton("OK");
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> dispose());
        ctrPane.add(btnOk);
        // TODO: 05.04.2016 добавить слушатель на кнопку и добавлять в базу данных новую категорию (на примере AccountAdd)
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
