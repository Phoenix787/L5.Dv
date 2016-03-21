package U2.L3.textfield;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ксения on 20.03.2016.
 * 789
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
                    e.printStackTrace();
                }


                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


                JTextField userTextField = new JTextField(10);
                JPasswordField passwordTextField = new JPasswordField(10);
                JPanel northPanel = new JPanel();
                northPanel.setLayout(new GridLayout(2, 2));
                northPanel.add(new JLabel("User name: ", JLabel.RIGHT));
                northPanel.add(userTextField);
                northPanel.add(new JLabel("Password: ", JLabel.RIGHT));
                northPanel.add(passwordTextField);
                frame.add(northPanel, BorderLayout.NORTH);

                final JTextArea textArea = new JTextArea(8, 20);
                JScrollPane scrollPane = new JScrollPane(textArea);

                frame.add(scrollPane, BorderLayout.CENTER);

                JPanel southPanel = new JPanel();
                JButton button = new JButton("Ok");
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textArea.append("User name: " + userTextField.getText() + "\nPassword: " + new String(passwordTextField.getPassword()) + "\n");
                    }
                });

                JCheckBox bold = new JCheckBox("Bold");
                JCheckBox italic = new JCheckBox("Italic");
                ActionListener listener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int mode = 0;
                        if (bold.isSelected()) {
                            mode += Font.BOLD;
                        }
                        if (italic.isSelected()){
                            mode += Font.ITALIC;
                        }
                        textArea.setFont(new Font("serif", mode, 12));
                    }
                };
                bold.addActionListener(listener);
                italic.addActionListener(listener);
                southPanel.add(bold);
                southPanel.add(italic);
                southPanel.add(button);

                frame.add(southPanel, BorderLayout.SOUTH);





                frame.setSize(450, 300);
                //frame.setResizable(false);
                frame.setVisible(true);
            }
        });

    }
}
