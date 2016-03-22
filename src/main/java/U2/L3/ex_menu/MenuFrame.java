package U2.L3.ex_menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Сергеева on 22.03.2016.
 */
public class MenuFrame extends JFrame {
    private static final long serialVersionUID = -5167666924169324755L;
    private JMenuBar menuBar;
    private JLabel label;
    private JPanel panel;

    MenuFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);
        JMenu aboutMenu = new JMenu("About");
        menuBar.add(aboutMenu);

        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener(new AbstractAction() {
            private static final long serialVersionUID = -8515803253457832233L;

            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(e.getActionCommand());
            }
        });
        fileMenu.add(newItem);
        newItem.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
                fileMenu.addSeparator();
        fileMenu.add(new JMenuItem(new AbstractAction("Exit") {
            private static final long serialVersionUID = -8293221225651746583L;

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        })).setAccelerator(KeyStroke.getKeyStroke("alt 4"));

        editMenu.add(new JCheckBoxMenuItem(new AbstractAction("Read only") {
            private static final long serialVersionUID = -3458198930993640762L;

            @Override
            public void actionPerformed(ActionEvent e) {
               label.setText(e.getActionCommand());
            }
        }));


        label = new JLabel("The quick fox...");
        label.setFont(new Font("Serif", Font.PLAIN, 24));

        panel = new JPanel();
        panel.add(label);
        add(panel);


        setSize(400,300);
    }
}
