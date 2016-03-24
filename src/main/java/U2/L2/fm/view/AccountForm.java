package U2.L2.fm.view;

import U2.L2.fm.controller.GUI;
import U2.L2.fm.model.DatabaseListModel;
import U2.L2.fm.model.datasets.Account;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Сергеева on 24.03.2016.
 */
public class AccountForm extends JFrame {
    private boolean succeeded;
    private final GUI controller;
    private  JTextField tfDescription;
    private  JTextField tfAmount;
    MainWindow parent;


    public AccountForm(GUI controller, MainWindow parent) {
        this.controller = controller;
        this.parent = parent;


        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EtchedBorder());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        JLabel lbDescription = new JLabel("Account description:");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;

        panel.add(lbDescription, c);

        tfDescription = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        panel.add(tfDescription, c);

        JLabel lbAmount = new JLabel("Amount:");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        panel.add(lbAmount, c);

        tfAmount = new JTextField(10);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        panel.add(tfAmount, c);


        add(panel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton btnSumbit = new JButton("Ok");
        btnSumbit.addActionListener(e->{
            if (controller.addAccount(controller.getOwner(), getDescription(), getAmount())){
                JOptionPane.showMessageDialog(AccountForm.this, "New account to " + controller.getOwner() +
                        " is added.", "New Account", JOptionPane.INFORMATION_MESSAGE);
                succeeded = true;
                //после закрытия формы обновить данные на MainWindow
                Set<String> data = updateListAccount();
                DatabaseListModel<String> stringDatabaseListModel = new DatabaseListModel<>();
                stringDatabaseListModel.setDataSource(data);
                parent.setDim(stringDatabaseListModel);
                parent.updateJList();


                dispose();


            } else{
                JOptionPane.showMessageDialog(AccountForm.this, "Such account already exists. " +
                        "\nPlease choose another description to account", "New Account", JOptionPane.ERROR_MESSAGE);
                succeeded = false;
                tfDescription.setText("");
            }

        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> dispose());

        btnPanel.add(btnSumbit);
        btnPanel.add(btnCancel);


        add(btnPanel, BorderLayout.PAGE_END);
        pack();
    }

    public void start(){
        setVisible(true);
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public String getDescription() {
        return tfDescription.getText();
    }

    public double getAmount() {
        return Double.valueOf(tfAmount.getText());
    }

    // TODO: 24.03.2016 добавить кнопку Add record...
    // TODO: 24.03.2016 добавить кнопку Delete account...


    public Set<String> updateListAccount() {
        Set<Account> temp = controller.getAccounts(controller.getOwner());
        Set<String> result = new HashSet<>();
        for (Account account : temp) {
            result.add(account.getDescription());
        }

        return result;
    }



}
