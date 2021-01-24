package controller;

import com.db4o.ObjectContainer;
import data.DataConnection;
import model.Product;
import model.User;
import view.AdminView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminController {

    AdminView adminView;
    private ObjectContainer db = DataConnection.getInstance();
    User user;
    boolean hiddenProducts;

    public AdminController(User user) {
        this.user = user;
        hiddenProducts = true;
        adminView = new AdminView();
        adminView.setVisible(true);
        adminView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initController();
    }

    private void listeners() {
        adminView.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db.close();
                System.exit(0);
            }
        });

        adminView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView.setVisible(false);
                new LoginController();
            }
        });

        adminView.getShowHideButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alternateBetweenShowing();
            }
        });
    }

    private void initController() {
        listeners();
        getProducts();
        adminView.getCurrentUserLabel().setText(user.getName());
        adminView.getShowingHiddenProductsLabel().setText(String.valueOf(hiddenProducts));
    }

    private void getProducts() {
        DefaultTableModel productTableModel = (DefaultTableModel) adminView.getProductTable().getModel();

        List<Product> products = db.query(Product.class);

        for (int i = 0; i < products.size(); i++) {
            productTableModel.addRow(new Object[]{
                    products.get(i).getCode(), products.get(i).getName(), String.valueOf(products.get(i).isHidden())
            });
        }
    }

    private void alternateBetweenShowing() {

        if (hiddenProducts) {
            hiddenProducts = false;
        } else {
            hiddenProducts = true;
        }

        DefaultTableModel productTableModel = (DefaultTableModel) adminView.getProductTable().getModel();



        List<Product> products = db.query(Product.class);

        for (int i = 0; i < products.size(); i++) {
            if (!products.get(i).isHidden() && !hiddenProducts) {
                productTableModel.addRow(new Object[]{
                        products.get(i).getCode(), products.get(i).getName(), String.valueOf(products.get(i).isHidden())
                });
            } else {
                productTableModel.addRow(new Object[]{
                        products.get(i).getCode(), products.get(i).getName(), String.valueOf(products.get(i).isHidden())
                });
            }
        }

    }
}
