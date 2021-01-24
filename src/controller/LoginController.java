package controller;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import data.DataConnection;
import model.User;
import view.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LoginController {

    LoginView loginView;
    private ObjectContainer db = DataConnection.getInstance();

    public LoginController() {
        loginView = new LoginView();
        loginView.setVisible(true);
        loginView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        listeners();
    }

    private void listeners() {
        JButton loginButton = loginView.getLoginButton();

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    private void login() {
        List<User> users = db.query(new Predicate<User>() {
            public boolean match(User u) {
                return u.getName().equals(loginView.getUserTextField().getText()) && u.getPassword().equals(loginView.getPasswordTextField().getText());
            }
        });

        if(users.size()>0) {
            if(users.get(0).isAdmin()) {
                loginView.setVisible(false);
                new AdminController(users.get(0));
            } else {
                loginView.setVisible(false);
                new UserController(users.get(0));
            }
        } else {
            JOptionPane.showMessageDialog(new JPanel(), "Incorrect login");
        }
    }



}
