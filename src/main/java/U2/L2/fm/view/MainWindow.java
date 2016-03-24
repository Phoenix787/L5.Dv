package U2.L2.fm.view;

import U2.L2.fm.controller.GUI;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.Set;

/**
 * Created by Ксения on 19.03.2016.
 */
public class MainWindow extends JFrame {

    public MainWindow(GUI controller){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 300);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EtchedBorder());

        JLabel lbUser = new JLabel("Пользователь: " + controller.getOwner());
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(lbUser, constraints);

        Set<String> temp = controller.getNames();
        String[] data = temp.toArray(new String[temp.size()]);
        JList<String> listUsers = new JList<>(data);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 2;
        panel.add(listUsers, constraints);





        getContentPane().add(panel, BorderLayout.CENTER);
    }

    public void start(){
        setVisible(true);
    }

}
