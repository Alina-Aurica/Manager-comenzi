package presentation;

import model.Client;
import model.Order;
import model.Product;
import start.ReflectionExample;

import javax.swing.*;
import java.util.ArrayList;

public class ShowTableOrder extends JFrame {
    private JTable orderTable;

    public ShowTableOrder(ArrayList<Order> orders)
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(320, 200);

        JPanel panel = new JPanel();

        Order order = null;
        order = orders.get(0);
        String[] coloane = new String[4];
        coloane[0] = ReflectionExample.retrieveProperties(order).get(0);
        coloane[1] = ReflectionExample.retrieveProperties(order).get(1);
        coloane[2] = ReflectionExample.retrieveProperties(order).get(2);
        coloane[3] = ReflectionExample.retrieveProperties(order).get(3);

        Object[][] linii = new Object[orders.size()][4];
        for(int i = 0; i < orders.size(); i++)
        {
            linii[i][0] = orders.get(i).getId();
            linii[i][1] = orders.get(i).getIdClient();
            linii[i][2] = orders.get(i).getIdProduct();
            linii[i][3] = orders.get(i).getQuantity();
        }

        orderTable = new JTable(linii, coloane);
        JScrollPane sp = new JScrollPane(orderTable);

        panel.add(sp);

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        this.setContentPane(panel);

    }
}
