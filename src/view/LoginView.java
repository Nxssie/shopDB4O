package view;

import javax.swing.*;

public class LoginView extends JFrame{

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JTextField userTextField;

    public LoginView() {
        super("Login");
        setLayout(null);
        setSize(320, 220);
        initComponents();
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JTextField();
        userTextField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();

        jLabel1.setText("User");
        jLabel1.setBounds(30, 20, 70, 20);
        add(jLabel1);

        jLabel2.setText("Password");
        jLabel2.setBounds(30, 70, 70, 20);
        add(jLabel2);

        passwordTextField.setBounds(30, 90, 250, 20);
        add(passwordTextField);

        userTextField.setBounds(30, 40, 250, 20);
        add(userTextField);

        loginButton.setText("Login");
        loginButton.setBounds(120, 140, 70, 20);
        add(loginButton);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(JTextField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    public JTextField getUserTextField() {
        return userTextField;
    }

    public void setUserTextField(JTextField userTextField) {
        this.userTextField = userTextField;
    }
}
