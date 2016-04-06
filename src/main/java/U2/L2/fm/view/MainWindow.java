package U2.L2.fm.view;

import U2.L2.fm.model.DatabaseListModel;
import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.datasets.Record;
import U2.L2.fm.model.interfaces.GUI;
import U2.L2.fm.model.tableModel.DatabaseTableModel;
import U2.L2.fm.model.util.ExitAction;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ксения on 19.03.2016.
 * главное окно
 */
public class MainWindow extends JFrame {
    private static final long serialVersionUID = -5778317887893855337L;

    private final GUI controller;
    private DatabaseListModel<String> dim;
    private DatabaseTableModel dtm;
    private JTable jTable;
    private JList<String> jList;
    private GridBagConstraints constraints;

    MainWindow(GUI controller){
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


        createMainMenu();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EtchedBorder());

        JLabel lbUser = new JLabel("Пользователь: " + controller.getOwner());
        Box header = Box.createHorizontalBox();
        header.add(Box.createHorizontalGlue());
        header.add(lbUser);
        header.add(Box.createHorizontalStrut(10));

        JPanel wrap = new JPanel();
        wrap.setLayout(new BoxLayout(wrap, BoxLayout.X_AXIS));
        jList = getJList();
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.addListSelectionListener(new ListSelectionListener() {
            String element;
            Account account;
            Set<Record> records;
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (e.getValueIsAdjusting()) {
                    element = jList.getSelectedValue();
                    account = controller.getAccount(element);
                    records = controller.getRecords(account);
                    dtm.setDataSource(records);
                    jTable.setModel(dtm);
                }
            }
        });
        JScrollPane listScrollPane = new JScrollPane(jList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        listScrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),"Accounts",
                TitledBorder.CENTER, TitledBorder.TOP));

        wrap.add(listScrollPane);
        // TODO: 06.04.2016 перед таблицей сделать два лейбла с информацией о сумме счета и расходах

        dtm = new DatabaseTableModel();
        jTable = new JTable(dtm);

        wrap.add(Box.createHorizontalStrut(5));
        JScrollPane tableScrollPane = new JScrollPane(jTable,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),"Records of account",
                TitledBorder.CENTER, TitledBorder.TOP));
        wrap.add(tableScrollPane);


        panel.add(header);
        panel.add(wrap);


        JPanel btnPanel = new JPanel();

        JButton btnAddAccount = new JButton("Add account...");
        btnAddAccount.addActionListener(e->{
                new AccountForm(controller, this).start();
        });

        btnPanel.add(btnAddAccount);

        JButton btnAddRecord = new JButton("Add Record...");
        btnAddRecord.addActionListener(e -> {
            String accountName = jList.getSelectedValue();
            if (accountName != null && !"".equals(accountName)) {
                Account account = controller.getAccount(accountName);
                new RecordForm(controller, account, this).start();
            } else {
                JOptionPane.showMessageDialog(null, "Please select an account from the list to which you want to attach a transaction ",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnPanel.add(btnAddRecord);



        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.PAGE_END);
    }


    public DatabaseListModel<String> getDim() {
        return dim;
    }

    void setDim(DatabaseListModel<String> dim) {
        this.dim = dim;
    }

    /**
     * Метод для создания JList
     * @return JList
     */
    @NotNull
    private JList<String> getJList() {
        dim = new DatabaseListModel<>();
        Set<String> data = getAccountsToList();
        dim.setDataSource(data);
        JList<String> listUsers = new JList<>();
        listUsers.setModel(dim);
        return listUsers;
    }

    /**
     * Метод для обновления списка на форме
     */

    void updateJList(){
        jList.setModel(dim);
    }

    /**
     * запускаем форму
     */

    public void start(){

        setVisible(true);
    }

    /**
     * получаем список accounts конкретного пользователя
     * @return Set<String> - набор названий счетов
     */

    private Set<String> getAccountsToList() {
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
        // TODO: 06.04.2016 повесить слушателя на смену пользователя
        JMenuItem exit = new JMenuItem(new ExitAction());
        // TODO: 06.04.2016 повесить слушателя на выход из приложения
        file.add(changeUser);
        file.addSeparator();
        file.add(exit);
        return file;
    }

    private JMenu createEditMenu() {
        JMenu edit = new JMenu("Редактирование");
        JMenuItem addAccount = new JMenuItem("Добавить счет");
        JMenuItem editAccount = new JMenuItem("Редактировать счет");
        edit.add(addAccount);
        edit.add(editAccount);

        return edit;
    }



}
