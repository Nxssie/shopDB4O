package controller;

import com.db4o.ObjectContainer;
import data.DataConnection;
import model.Product;
import model.User;
import view.UserView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserController {

    UserView userView;
    private ObjectContainer db = DataConnection.getInstance();
    User user;
    boolean hiddenProducts;

    public UserController(User user) {
        this.user = user;
        hiddenProducts = false;
        userView = new UserView();
        userView.setVisible(true);
        userView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initController();
    }

    private void initController() {
        listeners();
        getProducts();
        userView.getCurrentUserLabel().setText(user.getName());
        userView.getShowingHiddenProductsLabel().setText(String.valueOf(hiddenProducts));
    }

    private void listeners() {
        userView.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db.close();
                System.exit(0);
            }
        });

        userView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userView.setVisible(false);
                new LoginController();
            }
        });
    }

    private void getProducts() {
        DefaultTableModel productTableModel = (DefaultTableModel) userView.getProductTable().getModel();

        List<Product> products = db.query(Product.class);

        for (int i = 0; i < products.size(); i++) {
            if(!products.get(i).isHidden()) {
                productTableModel.addRow(new Object[] {
                        products.get(i).getCode(), products.get(i).getName(), String.valueOf(products.get(i).isHidden())
                });
            }
        }
    }
}
