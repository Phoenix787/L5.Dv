package U2.L2.fm.view;

import U2.L2.fm.model.interfaces.GUI;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;


public class RegistrationWindow extends JFrame {
    private static final long serialVersionUID = -5913221069279237982L;
    private JTextField tfUsername;
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private boolean succeeded;

    public RegistrationWindow(GUI controller) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        Toolkit kit = Toolkit.getDefaultToolkit();
//        Dimension screenSize = kit.getScreenSize();
//        int screenWith = screenSize.width;
//        int screenHeight = screenSize.height;
//        setSize(screenWith / 2, screenHeight / 2);
//        setLocation(screenWith/2 - this.getWidth()/2, screenHeight/2 - this.getHeight() / 2);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EtchedBorder());
        GridBagConstraints cs = new GridBagConstraints();
        cs.insets = new Insets(5, 5, 5, 5);
        cs.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblUsername = new JLabel("Name: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lblUsername, cs);

        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);

        JLabel lblEmail = new JLabel("Email: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lblEmail, cs);

        tfEmail = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(tfEmail, cs);

        JLabel lblPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(lblPassword, cs);

        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);

        JPanel btnPanel = new JPanel();

        JButton btnRegister = new JButton("Submit");
        btnRegister.addActionListener(e -> {
            if (!controller.authenticate(getUsername(), getPassword())){
                controller.register(getUsername(), getPassword());
                succeeded = true;
                dispose();

            } else{
                JOptionPane.showMessageDialog(RegistrationWindow.this, "User with such name is existed. " +
                        "\nChoose new username or login", "Register", JOptionPane.ERROR_MESSAGE);
                succeeded = false;
                tfUsername.setText("");
                pfPassword.setText("");
            }

        });
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> dispose());

        btnPanel.add(btnRegister);
        btnPanel.add(btnCancel);


        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.PAGE_END);
        pack();
    }

    private String getUsername() {
        return tfUsername.getText();
    }

    private String getEmail() {
        return tfEmail.getText();
    }

    private String getPassword() {
        return new String(pfPassword.getPassword());
    }

    public boolean isSucceeded(){
        return succeeded;
    }
}
