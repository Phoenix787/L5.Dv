package U2.L2.fm.view;

import U2.L2.fm.model.DatabaseListModel;
import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.interfaces.GUI;
import U2.L2.fm.model.util.ExitAction;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
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
    private JTable jTable;
    private JList<String> jList;
    private JPanel panel;
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

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EtchedBorder());

        JLabel lbUser = new JLabel("Пользователь: " + controller.getOwner());

        JPanel wrap = new JPanel();
        wrap.setLayout(new BoxLayout(wrap, BoxLayout.X_AXIS));
        jList = getJList();
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                JList<String> list = (JList<String>)e.getSource();
                String element = list.getSelectedValue();
                Account account = controller.getAccount(element);
               // List<Record> records = controller.getRecords(account);

               // System.out.println(records.toString());
            }
        });
        wrap.add(new JScrollPane(jList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

        // TODO: 31.03.2016 добавить JTable для размещения в ней данных о транзакции (Record)

        String[] data = {"Дата", "Описание", "Сумма", "Категория"};
        TableColumnModel headerColumns = new DefaultTableColumnModel();

        for (int i = 0; i < data.length; i++) {
            TableColumn h = new TableColumn(0);
            h.setHeaderValue(data[i]);
            headerColumns.addColumn(h);
        }

        jTable = new JTable();
        jTable.setTableHeader(new JTableHeader(headerColumns));

        wrap.add(Box.createHorizontalStrut(5));
        wrap.add(new JScrollPane(jTable,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));


        panel.add(Box.createHorizontalGlue());
        panel.add(lbUser);
        panel.add(Box.createHorizontalGlue());
        panel.add(wrap);



        // TODO: 30.03.2016 JTable




        JPanel btnPanel = new JPanel();

        JButton btnAddAccount = new JButton("Add account...");
        btnAddAccount.addActionListener(e->{
                new AccountForm(controller, this).start();
        });

        btnPanel.add(btnAddAccount);



        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.PAGE_END);
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
        jList.setModel(dim);
    }

    public void start(){

        setVisible(true);
    }

    private Set<String> updateListAccount() {
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
        JMenu edit = new JMenu("Редактирование");
        JMenuItem addAccount = new JMenuItem("Добавить счет");
        JMenuItem editAccount = new JMenuItem("Редактировать счет");
        edit.add(addAccount);
        edit.add(editAccount);

        return edit;
    }



}
