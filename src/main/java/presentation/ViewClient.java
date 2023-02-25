package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewClient extends JFrame {
    private JButton insertClient;
    private JButton updateClient;
    private JButton deleteClient;
    private JButton viewAllClient;
    private JLabel idClientLabel;
    private JTextField idClientField;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel addressLabel;
    private JTextField addressField;

    public ViewClient()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 200);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        insertClient = new JButton("insert Client");
        updateClient = new JButton("update Client");
        deleteClient = new JButton("delete Client");
        viewAllClient = new JButton("view Client");

        panel1.add(insertClient);
        panel1.add(updateClient);
        panel1.add(deleteClient);
        panel1.add(viewAllClient);

        idClientLabel = new JLabel("id: ");
        idClientField = new JTextField(4);
        nameLabel = new JLabel("name: ");
        nameField = new JTextField(20);
        addressLabel = new JLabel("address: ");
        addressField = new JTextField(30);

        panel2.add(idClientLabel);
        panel2.add(idClientField);
        panel2.add(nameLabel);
        panel2.add(nameField);
        panel2.add(addressLabel);
        panel2.add(addressField);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        this.setContentPane(panel);
    }

    public String getIdClientField() {
        return idClientField.getText();
    }

    public void setIdClientField(String id) {
        this.idClientField.setText(id);
    }

    public String getNameField() {
        return nameField.getText();
    }

    public void setNameField(String name) {
        this.nameField.setText(name);
    }

    public String getAddressField() {
        return addressField.getText();
    }

    public void setAddressField(String address) {
        this.addressField.setText(address);
    }

    public void addInsertClientListener(ActionListener e) {

        insertClient.addActionListener(e);
    }

    public void addUpdateClientListener(ActionListener e) {

        updateClient.addActionListener(e);
    }

    public void addDeleteClientListener(ActionListener e) {

        deleteClient.addActionListener(e);
    }

    public void addViewAllClientListener(ActionListener e) {

        viewAllClient.addActionListener(e);
    }
}
