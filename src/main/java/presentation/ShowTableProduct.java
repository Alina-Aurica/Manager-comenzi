package presentation;

import model.Client;
import model.Product;
import start.ReflectionExample;

import javax.swing.*;
import java.util.ArrayList;

public class ShowTableProduct extends JFrame{
    private JTable productTable;

    public ShowTableProduct(ArrayList<Product> products)
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(320, 200);

        JPanel panel = new JPanel();

        Product product = null;
        product = products.get(0);
        String[] coloane = new String[3];
        coloane[0] = ReflectionExample.retrieveProperties(product).get(0);
        coloane[1] = ReflectionExample.retrieveProperties(product).get(1);
        coloane[2] = ReflectionExample.retrieveProperties(product).get(2);

        Object[][] linii = new Object[products.size()][3];
        for(int i = 0; i < products.size(); i++)
        {
            linii[i][0] = products.get(i).getId();
            linii[i][1] = products.get(i).getName();
            linii[i][2] = products.get(i).getStoc();
        }

        productTable = new JTable(linii, coloane);
        JScrollPane sp = new JScrollPane(productTable);

        panel.add(sp);

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        this.setContentPane(panel);

    }
}
