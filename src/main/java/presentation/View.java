package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
//TODO:...
    private JButton buttonClient;
    private JButton buttonProduct;
    private JButton buttonOrder;

    public View()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(320, 200);

        JPanel panel = new JPanel();

        buttonClient = new JButton("view Client");
        buttonProduct = new JButton("view Product");
        buttonOrder = new JButton("view Order");

        panel.add(buttonClient, Component.CENTER_ALIGNMENT);
        panel.add(buttonProduct, Component.CENTER_ALIGNMENT);
        panel.add(buttonOrder, Component.CENTER_ALIGNMENT);

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        this.setContentPane(panel);
    }

    public void addClientListener(ActionListener e) {

        buttonClient.addActionListener(e);
    }

    public void addProductListener(ActionListener e) {

        buttonProduct.addActionListener(e);
    }

    public void addOrderListener(ActionListener e) {

        buttonOrder.addActionListener(e);
    }


}
