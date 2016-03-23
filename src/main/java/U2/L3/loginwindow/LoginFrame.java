package U2.L3.loginwindow;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Сергеева on 23.03.2016.
 */
public class LoginFrame extends JFrame {

    private static final long serialVersionUID = -321545275502211256L;

    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbRegister;
    private JLabel lbUsername;
    private JLabel lbPassword;

    private JButton btnLogin;
    private JButton btnCancel;
    private boolean succeeded;


    LoginFrame(){

        setTitle("Login");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new CompoundBorder(new EmptyBorder(5,5,5,5), new EtchedBorder()));
        GridBagConstraints cs = new GridBagConstraints();
        cs.insets = new Insets(2,2,2,2);
        cs.fill = GridBagConstraints.HORIZONTAL;
        lbUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.ipadx = 5;
        cs.ipady = 5;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);

        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);

        lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);

        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);

        lbRegister = new JLabel("Register", JLabel.RIGHT);
        lbRegister.setFont(new Font(Font.SANS_SERIF, FontUIResource.BOLD, 12));
        lbRegister.setForeground(Color.blue);
        lbRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO: 23.03.2016 написать открытие формы Регистрация
                System.out.println("Регистрация");
            }
        });
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(lbRegister, cs);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> {
            if (LoginController.authenticate(getUserName(), getPassword())){
                JOptionPane.showMessageDialog(LoginFrame.this, "Hi, " + getUserName() + "!\nYou have " +
                        "successfully logged in.", "Login", JOptionPane.INFORMATION_MESSAGE);
                succeeded = true;
                // TODO: 23.03.2016 сделать чтобы форма открывалась посередине рабочего стола
                // TODO: 23.03.2016  сделать открытие главного окна финансового менеджера
                dispose();
            } else {
                JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password", "Login",
                        JOptionPane.ERROR_MESSAGE);
                tfUsername.setText("");
                pfPassword.setText("");
                succeeded = false;

            }

        });
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> dispose());

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnLogin);
        btnPanel.add(btnCancel);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.PAGE_END);
        setResizable(false);
        pack();

    }

    private String getPassword() {
        return new String(pfPassword.getPassword());
    }

    private String getUserName() {
        return tfUsername.getText();
    }

    public boolean isSucceeded() {
        return succeeded;
    }

}
