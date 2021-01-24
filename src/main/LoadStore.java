package main;

import com.db4o.ObjectContainer;
import data.DataConnection;
import model.Product;
import model.User;

public class LoadStore {

    private static ObjectContainer db = DataConnection.getInstance();

    public void main(String[] args) {
        loadAll();
    }

    private void loadAll() {
        User u1 = new User("admin", "admin", true);
        User u2 = new User("user", "user", false);

        Product p1 = new Product(1, "TestProduct", false);
        Product p2 = new Product(2, "TestProduct 2", false);
        Product p3 = new Product(3, "TestProduct 3", true);

        db.store(u1);
        db.store(u2);

        db.store(p1);
        db.store(p2);
        db.store(p3);
    }

}
