package view;

import javax.swing.*;

public class UserView extends JFrame {

    private JButton backButton;
    private JLabel currentUserLabel;
    private JButton exitButton;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane2;
    private JTable productTable;
    private JLabel showingHiddenProductsLabel;

    public UserView() {
        super("User");
        setLayout(null);
        setSize(820, 450);
        initComponents();
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        showingHiddenProductsLabel = new JLabel();
        currentUserLabel = new JLabel();
        jScrollPane2 = new JScrollPane();
        productTable = new JTable();
        backButton = new JButton();
        exitButton = new JButton();

        //Setting up components
        jLabel1.setText("Showing hidden products:");
        jLabel1.setBounds(30, 300, 150, 30);
        add(jLabel1);

        jLabel2.setText("Current user:");
        jLabel2.setBounds(30, 250, 80, 30);
        add(jLabel2);

        showingHiddenProductsLabel.setBounds(200, 300, 200, 30);
        add(showingHiddenProductsLabel);

        currentUserLabel.setBounds(110, 250, 200, 30);
        add(currentUserLabel);

        productTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Code", "Name", "Hidden"
                }
        ));
        jScrollPane2.setViewportView(productTable);

        jScrollPane2.setBounds(20, 20, 750, 220);
        add(jScrollPane2);

        backButton.setText("Back");
        backButton.setBounds(20, 362, 80, 30);
        add(backButton);

        exitButton.setText("Exit");
        exitButton.setBounds(700, 362, 80, 30);
        add(exitButton);
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JLabel getCurrentUserLabel() {
        return currentUserLabel;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JTable getProductTable() {
        return productTable;
    }

    public JLabel getShowingHiddenProductsLabel() {
        return showingHiddenProductsLabel;
    }
}
