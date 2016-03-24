package U2.L2.fm.view;

import U2.L2.fm.controller.GUI;
import U2.L2.fm.model.datasets.Account;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;

/**
 * Created by Ксения on 19.03.2016.
 */
public class MainWindow extends JFrame {
    private final GUI controller;
    private DefaultListModel<String> dim;

    public MainWindow(GUI controller){
        this.controller = controller;
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Account close");
                super.windowClosed(e);


            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWith = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWith / 2, screenHeight / 2);
        setLocation(screenWith/2 - this.getWidth()/2, screenHeight/2 - this.getHeight() / 2);
        //setLocationRelativeTo(null);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EtchedBorder());

        JLabel lbUser = new JLabel("Пользователь: " + controller.getOwner());
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(lbUser, constraints);

//        Set<Account> temp = controller.getAccounts(controller.getOwner());
//        Account[] data = temp.toArray(new Account[temp.size()]);
//        String[] strData = new String[temp.size()];
//        for (int i = 0; i < strData.length; i++) {
//            strData[i] = data[i].getDescription();
//        }

        dim = new DefaultListModel<>();

        String[] strData = controller.updateListAccount();
        for (int i = 0; i < strData.length; i++) {
            dim.add(i, strData[i]);
        }
        JList<String> listUsers = new JList<>(strData);
        listUsers.setModel(dim);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 2;
        panel.add(listUsers, constraints);

        JPanel btnPanel = new JPanel();

        JButton btnAddAccount = new JButton("Add account...");
        btnAddAccount.addActionListener(e->{
            SwingUtilities.invokeLater(()->{
                new AccountForm(controller).start();

            });
        });

        btnPanel.add(btnAddAccount);





        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.PAGE_END);
    }

    public void start(){

        setVisible(true);
    }

//    public String[] updateListAccount() {
//        Set<Account> temp = controller.getAccounts(controller.getOwner());
//        Account[] data = temp.toArray(new Account[temp.size()]);
//        String[] strData = new String[temp.size()];
//        for (int i = 0; i < strData.length; i++) {
//            strData[i] = data[i].getDescription();
//        }
//        return strData;
//    }

}
