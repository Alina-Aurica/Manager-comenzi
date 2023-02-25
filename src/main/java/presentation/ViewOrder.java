package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewOrder extends JFrame {
    private JButton insertOrder;
    private JButton updateOrder;
    private JButton deleteOrder;
    private JButton viewAllOrder;
    private JLabel idOrderLabel;
    private JTextField idOrderField;
    private JLabel idClientLabel;
    private JTextField idClientField;
    private JLabel idProductLabel;
    private JTextField idProductField;
    private JLabel quantityLabel;
    private JTextField quantityField;
    private JLabel warningMsj;


    public ViewOrder()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 200);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        insertOrder = new JButton("insert Order");
        updateOrder = new JButton("update Order");
        deleteOrder = new JButton("delete Order");
        viewAllOrder = new JButton("view Order");

        panel1.add(insertOrder);
        panel1.add(updateOrder);
        panel1.add(deleteOrder);
        panel1.add(viewAllOrder);

        idOrderLabel = new JLabel("idOrder: ");
        idOrderField = new JTextField(4);
        idClientLabel = new JLabel("idClient: ");
        idClientField = new JTextField(4);
        idProductLabel = new JLabel("idProduct: ");
        idProductField = new JTextField(4);
        quantityLabel = new JLabel("quantity: ");
        quantityField = new JTextField(10);

        panel2.add(idOrderLabel);
        panel2.add(idOrderField);
        panel2.add(idClientLabel);
        panel2.add(idClientField);
        panel2.add(idProductLabel);
        panel2.add(idProductField);
        panel2.add(quantityLabel);
        panel2.add(quantityField);

        warningMsj = new JLabel();
        panel3.add(warningMsj);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        this.setContentPane(panel);
    }

    public String getIdOrderField(){
        return idOrderField.getText();
    }

    public void setIdOrderField(String id){
        this.idOrderField.setText(id);
    }

    public String getIdClientField() {
        return idClientField.getText();
    }

    public void setIdClientField(String id) {
        this.idClientField.setText(id);
    }

    public String getIdProductField() {
        return idProductField.getText();
    }

    public void setIdProductField(String id) {
        this.idProductField.setText(id);
    }

    public String getQuantityField() {
        return quantityField.getText();
    }

    public void setQuantityField(String quantity) {
        this.quantityField.setText(quantity);
    }

    public void setWarningMsj(String msj){
        this.warningMsj.setText(msj);
    }

    public void addInsertOrderListener(ActionListener e) {

        insertOrder.addActionListener(e);
    }

    public void addUpdateOrderListener(ActionListener e) {

        updateOrder.addActionListener(e);
    }

    public void addDeleteOrderListener(ActionListener e) {

        deleteOrder.addActionListener(e);
    }

    public void addViewAllOrderListener(ActionListener e) {

        viewAllOrder.addActionListener(e);
    }
}
