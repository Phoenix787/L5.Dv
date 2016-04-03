package U2.L2.fm.view;

import U2.L2.fm.model.DatabaseListModel;
import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.interfaces.GUI;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class MainView extends JFrame {
    private final GUI controller;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList list1;
    private JTable table1;
    private JLabel lbUser;

    private DatabaseListModel<String> dim;



    public MainView(GUI controller) {
        this.controller = controller;

        setContentPane(contentPane);
        //setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        lbUser.setText("Пользователь: " + this.controller.getOwner());
       // updateJList();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public DatabaseListModel<String> getDim() {
        return dim;
    }

    void setDim(DatabaseListModel<String> dim) {
        this.dim = dim;
    }

    @NotNull
    private JList<String> getJList() {
        dim = new DatabaseListModel<>();
        Set<String> data = updateListAccount();
        dim.setDataSource(data);
        JList<String> listUsers = new JList<>();
        listUsers.setModel(dim);
        return listUsers;
    }

    void updateJList(){
        list1.setModel(dim);
    }

    private Set<String> updateListAccount() {
        Set<Account> temp = controller.getAccounts(controller.getOwner());
        Set<String> result = new HashSet<>();
        for (Account account : temp) {
            result.add(account.getDescription());
        }

        return result;
    }


}
