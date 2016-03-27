package U2.L2.fm.view;

import U2.L2.fm.model.interfaces.GUI;
import U2.L2.fm.model.DatabaseListModel;
import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.util.ExitAction;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ксения on 19.03.2016.
 */
public class MainWindow extends JFrame {
    private final GUI controller;
    private DatabaseListModel<String> dim;

    public DatabaseListModel<String> getDim() {
        return dim;
    }

    public void setDim(DatabaseListModel<String> dim) {
        this.dim = dim;
    }

    private JList<String> jList;


    public MainWindow(GUI controller){
        this.controller = controller;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Financial Manager: " + controller.getOwner());

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

        createMainMenu();

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EtchedBorder());

        JLabel lbUser = new JLabel("Пользователь: " + controller.getOwner());
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(lbUser, constraints);

        jList = getJList();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 2;
//        panel.add(jList, constraints);
        panel.add(new JScrollPane(jList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), constraints);

        JPanel btnPanel = new JPanel();

        JButton btnAddAccount = new JButton("Add account...");
        btnAddAccount.addActionListener(e->{

                new AccountForm(controller, this).start();


        });

        btnPanel.add(btnAddAccount);



        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.PAGE_END);
    }

    @NotNull
    public JList<String> getJList() {
        dim = new DatabaseListModel<>();
        Set<String> data = updateListAccount();
        dim.setDataSource(data);
        JList<String> listUsers = new JList<>();
        listUsers.setModel(dim);
        return listUsers;
    }

    public void updateJList(){
        jList.setModel(dim);
    }

    public void start(){

        setVisible(true);
    }

    public Set<String> updateListAccount() {
        Set<Account> temp = controller.getAccounts(controller.getOwner());
        Set<String> result = new HashSet<>();
        for (Account account : temp) {
            result.add(account.getDescription());
        }

        return result;
    }

    // TODO: 25.03.2016 make mainMenu createMainManu()

    private void createMainMenu(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createEditMenu());
        setJMenuBar(menuBar);
    }

    private JMenu createFileMenu(){
        JMenu file = new JMenu("File");
        JMenuItem changeUser = new JMenuItem("Сменить пользователя", new ImageIcon("img/open.gif"));
        JMenuItem exit = new JMenuItem(new ExitAction());
        file.add(changeUser);
        file.addSeparator();
        file.add(exit);
        return file;
    }

    private JMenu createEditMenu() {
        JMenu edit = new JMenu("Edit");
        JCheckBoxMenuItem bold = new JCheckBoxMenuItem("Bold");
        JCheckBoxMenuItem italic = new JCheckBoxMenuItem("Italic");
        JCheckBoxMenuItem underline = new JCheckBoxMenuItem("Underline");

        JRadioButtonMenuItem male = new JRadioButtonMenuItem("Man");
        JRadioButtonMenuItem female = new JRadioButtonMenuItem("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        edit.add(bold);
        edit.add(italic);
        edit.add(underline);
        edit.add(male);
        edit.add(female);

        return edit;
    }

}
