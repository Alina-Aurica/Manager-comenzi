package presentation;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import dao.AbstractDAO;
import model.Client;
import model.Order;
import model.Product;
import start.Start;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class Controller {
//TODO:...
    protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

    private View view;
    private ViewClient viewClient;
    private ViewProduct viewProduct;
    private ViewOrder viewOrder;

    public Controller(View view){
        this.view = view;

        view.addClientListener(new ClientListener());
        view.addProductListener(new ProductListener());
        view.addOrderListener(new OrderListener());
    }

    class ClientListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setVisible(true);
            //view.dispose();

            viewClient = new ViewClient();
            viewClient.setVisible(true);

            viewClient.addViewAllClientListener(new ViewAllClientListener());
            viewClient.addInsertClientListener(new InsertClientListener());
            viewClient.addUpdateClientListener(new UpdateClientListener());
            viewClient.addDeleteClientListener(new DeleteClientListener());
        }
    }

    class ProductListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setVisible(true);
            //view.dispose();

            viewProduct = new ViewProduct();
            viewProduct.setVisible(true);

            viewProduct.addViewAllProductListener(new ViewAllProductListener());
            viewProduct.addInsertProductListener(new InsertProductListener());
            viewProduct.addUpdateProductListener(new UpdateProductListener());
            viewProduct.addDeleteProductListener(new DeleteProductListener());
        }
    }

    class OrderListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setVisible(true);
            //view.dispose();

            viewOrder = new ViewOrder();
            viewOrder.setVisible(true);

            viewOrder.addViewAllOrderListener(new ViewAllOrderListener());
            viewOrder.addInsertOrderListener(new InsertOrderListener());
        }
    }

    class ViewAllClientListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ClientBLL clientBLL = new ClientBLL();
            ShowTableClient clientTable = new ShowTableClient(clientBLL.findAllClient());

            clientTable.setVisible(true);
        }
    }

    class InsertClientListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ClientBLL clientBLL = new ClientBLL();

            int id = Integer.parseInt(viewClient.getIdClientField());
            System.out.println(id);
            String name = viewClient.getNameField();
            System.out.println(name);
            String adresa = viewClient.getAddressField();
            System.out.println(adresa);

            Client client = new Client(id, name, adresa);
            //System.out.println(client.toString());

            if(clientBLL.findByID(id) != null){
                System.out.println("Baza de date contine deja un client cu acest id");
            }
            else{
                clientBLL.insertClient(client);
            }

        }
    }

    class UpdateClientListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ClientBLL clientBLL = new ClientBLL();

            int id = Integer.parseInt(viewClient.getIdClientField());
            System.out.println(id);
            String name = viewClient.getNameField();
            System.out.println(name);
            String adresa = viewClient.getAddressField();
            System.out.println(adresa);

            Client client = new Client(id, name, adresa);
            //System.out.println(client.toString());

            if(clientBLL.findByID(id) != null){
                clientBLL.updateClient(client);
            }
        }
    }

    class DeleteClientListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ClientBLL clientBLL = new ClientBLL();

            int id = Integer.parseInt(viewClient.getIdClientField());
            System.out.println(id);
            String name = viewClient.getNameField();
            System.out.println(name);
            String adresa = viewClient.getAddressField();
            System.out.println(adresa);

            Client client = new Client(id, name, adresa);
            //System.out.println(client.toString());

            if(clientBLL.findByID(id) != null){
                clientBLL.deleteClient(client);
            }
        }
    }

    class ViewAllProductListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ProductBLL productBLL = new ProductBLL();
            ShowTableProduct productTable = new ShowTableProduct(productBLL.findAllProduct());

            productTable.setVisible(true);
        }
    }

    class InsertProductListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ProductBLL productBLL = new ProductBLL();

            int id = Integer.parseInt(viewProduct.getIdProductField());
            System.out.println(id);
            String name = viewProduct.getNameField();
            System.out.println(name);
            int stoc = Integer.parseInt(viewProduct.getQuantityField());
            System.out.println(stoc);

            Product product = new Product(id, name, stoc);
            //System.out.println(client.toString());

            if(productBLL.findByID(id) != null){
                System.out.println("Baza de date contine deja un produs cu acest id");
            }
            else{
                productBLL.insertProduct(product);
            }
        }
    }

    class UpdateProductListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ProductBLL productBLL = new ProductBLL();

            int id = Integer.parseInt(viewProduct.getIdProductField());
            System.out.println(id);
            String name = viewProduct.getNameField();
            System.out.println(name);
            int stoc = Integer.parseInt(viewProduct.getQuantityField()); //cand introducem date pt stergere, la quantity trebuie adaugat 0
            System.out.println(stoc);

            Product product = new Product(id, name, stoc);
            //System.out.println(client.toString());

            if (productBLL.findByID(id) != null) {
                productBLL.updateProduct(product);
            }
        }
    }

    class DeleteProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ProductBLL productBLL = new ProductBLL();

            int id = Integer.parseInt(viewProduct.getIdProductField());
            System.out.println(id);
            String name = viewProduct.getNameField();
            System.out.println(name);
            int stoc = Integer.parseInt(viewProduct.getQuantityField()); //cand introducem date pt stergere, la quantity trebuie adaugat 0
            System.out.println(stoc);

            Product product = new Product(id, name, stoc);
            //System.out.println(client.toString());

            if (productBLL.findByID(id) != null) {
                productBLL.deleteProduct(product);
            }
        }
    }

    class ViewAllOrderListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            OrderBLL orderBLL = new OrderBLL();
            ShowTableOrder orderTable = new ShowTableOrder(orderBLL.findAllOrder());

            orderTable.setVisible(true);
            }
    }

    class InsertOrderListener implements ActionListener {

        public void scriereFisier(String result)
        {
            try {
                FileWriter myFile = new FileWriter("myFile.txt");
                myFile.write(result);
                myFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String result = new String();
            OrderBLL orderBLL = new OrderBLL();

            int id = Integer.parseInt(viewOrder.getIdOrderField());
            System.out.println(id);
            int idClient = Integer.parseInt(viewOrder.getIdClientField());
            System.out.println(idClient);
            int idProduct = Integer.parseInt(viewOrder.getIdProductField());
            System.out.println(idProduct);
            int quantity = Integer.parseInt(viewOrder.getQuantityField());
            System.out.println(quantity);

            Order order = new Order(id, idClient, idProduct, quantity);

            if (orderBLL.findByID(id) != null) {
                System.out.println("Baza de date contine deja o comanda cu acest id");
            } else {
                ProductBLL productBLL = new ProductBLL();
                ClientBLL clientBLL = new ClientBLL();
                if (productBLL.findByID(idProduct) != null && clientBLL.findByID(idClient) != null) {
                    if (productBLL.findByID(idProduct).getStoc() > quantity)
                    {
                        orderBLL.insertOrder(order);
                        int idP = productBLL.findByID(idProduct).getId();
                        String numeP = productBLL.findByID(idProduct).getName();
                        int quantityP = productBLL.findByID(idProduct).getStoc() - quantity;
                        Product product = new Product(idP, numeP, quantityP);
                        productBLL.updateProduct(product);

                        result = clientBLL.findByID(idClient).toString() + " a cumparat produsul" + "\n" + productBLL.findByID(idProduct).getName() + " in cantitate de " + quantity + " bucati";
                        scriereFisier(result);
                    }
                    else
                        viewOrder.setWarningMsj("cantitatea este mai mare decat stocul produsului");
                }
            }
        }
    }
}



