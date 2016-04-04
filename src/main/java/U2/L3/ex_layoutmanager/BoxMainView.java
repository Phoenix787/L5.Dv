package U2.L3.ex_layoutmanager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Сергеева on 01.04.2016.
 */
public class BoxMainView extends JFrame {
    private final JButton btnExit;
    private final JButton btnAddAccount;
    private JLabel lUser;
    private JList<String> jList;
    private JTable jTable;
    private final JButton btnAddRecord;

    public BoxMainView(){
        super("Финансовый менеджер");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        Box main = Box.createVerticalBox();

        Box pHeader = Box.createHorizontalBox();
        pHeader.add(Box.createHorizontalGlue());
        lUser = new JLabel("Пользователь: ");
        pHeader.add(lUser);
        pHeader.add(Box.createHorizontalGlue());

        Box wrapper = Box.createHorizontalBox();
        JPanel pList = new JPanel(new BorderLayout(5,5));
        jList = createList();
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                btnAddRecord.setEnabled(true);
            }
        });
        pList.add(jList, BorderLayout.CENTER);

        JPanel pTable = new JPanel(new BorderLayout());
        jTable = createTable();
        pTable.add(jTable, BorderLayout.CENTER);

        wrapper.add(Box.createVerticalStrut(5));
        wrapper.add(Box.createHorizontalStrut(5));
        wrapper.add(pList);
        wrapper.add(Box.createHorizontalStrut(10));
        wrapper.add(pTable);
        wrapper.add(Box.createHorizontalStrut(5));
        wrapper.add(Box.createVerticalStrut(5));

        Box pButtons = Box.createHorizontalBox();
        pButtons.add(Box.createHorizontalGlue());
        btnAddAccount = new JButton("Add account");
        pButtons.add(btnAddAccount);
        pButtons.add(Box.createHorizontalStrut(5));
        btnAddRecord = new JButton("Add record");
        btnAddRecord.setEnabled(false);
        pButtons.add(btnAddRecord);
        pButtons.add(Box.createHorizontalStrut(5));
        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        pButtons.add(btnExit);
        pButtons.add(Box.createHorizontalGlue());

        main.add(pHeader);
        main.add(Box.createVerticalStrut(5));
        main.add(wrapper);
        main.add(Box.createVerticalGlue());
        main.add(Box.createVerticalStrut(5));

        getContentPane().add(main, BorderLayout.CENTER);
        getContentPane().add(pButtons, BorderLayout.SOUTH);

        setVisible(true);

    }

    public JList<String> createList(){
        String[] data = {"element 1 ", "element 2 ", "element 3 "};
        return new JList<>(data);
    }

    public JTable createTable(){
        String[] columns = {"ID", "Description", "Date", "Amount"};
        String[][] data = {
                {"1", "За телефон", "21/03/2016", "200"},
                {"2", "За интернет", "21/03/2016", "800"},
                {"3", "Покупка продуктов Магнит", "18/03/2016", "2500"},
                {"4", "Ремонт сапог", "10/03/2016", "600"},
        };
        JTable jTable = new JTable(data, columns);
        jTable.setSize(new Dimension(50, 100));
        return jTable;
    }

    public static void main(String[] args) {
        new BoxMainView();
    }
}
