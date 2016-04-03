package U2.L3.windowlistener;

import U2.L2.fm.controller.DBHelper;
import U2.L2.fm.model.interfaces.GUI;
import U2.L2.fm.controller.LoginWindowController;
import U2.L2.fm.model.FinancialManager;
import U2.L2.fm.model.datasets.Account;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ксения on 24.03.2016.
 */
public class MainForm extends JFrame {
    private DatabaseListModel<String> dim;
    private GUI controller = new LoginWindowController(new FinancialManager(DBHelper.getInstance()));


    public MainForm(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        dim = new DatabaseListModel<>();
        Set<String> data = updateListAccount(controller.getOwner());


        dim.setDataSource(data);
        JList<String> jList = new JList<>();
        jList.setSize(40, 30);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setModel(dim);
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String element = jList.getSelectedValue();
                System.out.println(element);
            }
        });
        panel.add(new JScrollPane(jList));


        //panel.add(jList);

//        JPanel btnPanel = new JPanel();
//        JButton btn = new JButton("Add");
//        btn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dim.
//            }
//        });
//
//        btnPanel.add(btn);


        getContentPane().add(panel, BorderLayout.CENTER);
//        getContentPane().add(btnPanel, BorderLayout.SOUTH);

        setSize(300, 200);
        setVisible(true);
    }

    public Set<String> updateListAccount(String name) {
        Set<Account> temp = controller.getAccounts(name);
        Set<String> result = new HashSet<>();
        for (Account account : temp) {
            result.add(account.getDescription());
        }

        return result;
    }
}
