package U2.L3.ex_jlist_jtable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ксения on 31.03.2016.
 */
public class MainWindow extends JFrame {
    private JList list1;
    private JTable table1;

    public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 300);
        setTitle("Example");

        list1 = createList();
        table1 = createTable();

        Box main = Box.createVerticalBox();

        Box content = Box.createHorizontalBox();

        JPanel pList = new JPanel(new BorderLayout());
        pList.add(new JScrollPane(list1), BorderLayout.CENTER);

        JPanel pTable = new JPanel(new BorderLayout());
        pTable.add(new JScrollPane(table1), BorderLayout.CENTER);

        content.add(pList);
        content.add(Box.createHorizontalGlue());
        content.add(pTable);

        main.add(content);

        Box buttonCommands = Box.createHorizontalBox();

        JButton bAccount = new JButton("Account");
        bAccount.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        JButton bExit = new JButton("Exit");
        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        bExit.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        buttonCommands.add(Box.createHorizontalGlue());
        buttonCommands.add(bAccount);
        buttonCommands.add(bExit);
        buttonCommands.add(Box.createHorizontalStrut(5));
       // buttonCommands.add(Box.createVerticalStrut(5));

        main.add(buttonCommands);

        getContentPane().add(main);
        //getContentPane().add(buttonCommands, BorderLayout.SOUTH);

        pack();

        setVisible(true);

    }

    private JTable createTable() {
        String[] columns = {"Name", "Last modified", "Type", "Size"};
        String[][] data = {
                {"addins", "02.11.2006 19:15", "Folder", ""},
                {"AppPatch", "03.10.2006 14:10", "Folder", ""},
                {"assembly", "02.11.2006 14:20", "Folder", ""}
        };
        JTable jTable = new JTable(data, columns);
        jTable.setSize(new Dimension(200, 200));
        return jTable;
    }

    private JList createList() {
        String[] elements = {"element1   ", "element2   ", "element3   "};

        JList<String> jList = new JList<>(elements);
        jList.setSize(new Dimension(50, 200));

        return jList;
    }


}
