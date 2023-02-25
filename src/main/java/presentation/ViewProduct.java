package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewProduct extends JFrame {
    private JButton insertProduct;
    private JButton updateProduct;
    private JButton deleteProduct;
    private JButton viewAllProduct;
    private JLabel idProductLabel;
    private JTextField idProductField;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel quantityLabel;
    private JTextField quantityField;

    public ViewProduct()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 200);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        insertProduct = new JButton("insert Product");
        updateProduct = new JButton("update Product");
        deleteProduct = new JButton("delete Product");
        viewAllProduct = new JButton("view Product");

        panel1.add(insertProduct);
        panel1.add(updateProduct);
        panel1.add(deleteProduct);
        panel1.add(viewAllProduct);

        idProductLabel = new JLabel("id: ");
        idProductField = new JTextField(4);
        nameLabel = new JLabel("name: ");
        nameField = new JTextField(20);
        quantityLabel = new JLabel("quantity: ");
        quantityField = new JTextField(6);

        panel2.add(idProductLabel);
        panel2.add(idProductField);
        panel2.add(nameLabel);
        panel2.add(nameField);
        panel2.add(quantityLabel);
        panel2.add(quantityField);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        this.setContentPane(panel);
    }

    public String getIdProductField() {
        return idProductField.getText();
    }

    public void setIdProductField(String id) {
        this.idProductField.setText(id);
    }

    public String getNameField() {
        return nameField.getText();
    }

    public void setNameField(String name) {
        this.nameField.setText(name);
    }

    public String getQuantityField() {
        return quantityField.getText();
    }

    public void setQuantityField(String address) {
        this.quantityField.setText(address);
    }

    public void addInsertProductListener(ActionListener e) {

        insertProduct.addActionListener(e);
    }

    public void addUpdateProductListener(ActionListener e) {

        updateProduct.addActionListener(e);
    }

    public void addDeleteProductListener(ActionListener e) {

        deleteProduct.addActionListener(e);
    }

    public void addViewAllProductListener(ActionListener e) {

        viewAllProduct.addActionListener(e);
    }
}
